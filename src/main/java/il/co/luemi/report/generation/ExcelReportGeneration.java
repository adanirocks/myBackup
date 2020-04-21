/*
 * Copyright Leumi Bank . All Rights Reserved.
 * This software is the proprietary information of Leumi Bank.
 * Use is subject to license terms.
 */
package il.co.luemi.report.generation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;

import il.co.luemi.constants.AppDataConstants;
import il.co.luemi.constants.AppDataErrorConstant;
import il.co.luemi.exception.AppDataResourceNotFoundException;
import il.co.luemi.model.GenerateSheetWithColumn;
import il.co.luemi.response.CustomerDetailsResponse;
import il.co.luemi.util.ApplicationMgmtUtil;

/**
 * The Class ExcelReportGeneration.
 *
 * @author TCS
 */
public class ExcelReportGeneration {
	
	private  static final  Logger LOG = LogManager.getLogger(ExcelReportGeneration.class);

	/**
	 * The method to Generate sheet.
	 *
	 * @param reportName the report name
	 * @return the generate sheet with column
	 * @throws NoSuchFieldException the no such field exception
	 * @throws SecurityException    the security exception
	 * @throws IOException          Signals that an I/O exception has occurred.
	 */
	public static GenerateSheetWithColumn generateSheet(String reportName)
			throws NoSuchFieldException, SecurityException, IOException {

		GenerateSheetWithColumn generateSheetWithColumn = new GenerateSheetWithColumn();
		// create blank workbook
		HSSFWorkbook workbook = new HSSFWorkbook();
		// Create a blank sheet
		HSSFSheet sheet = workbook.createSheet();
		List<ColumnParameter> columnParameter = null;

		Row rowHeading = sheet.createRow(0);
		ReportGeneration loadConfig = ApplicationMgmtUtil.loadConfig();
		List<ReportOutput> reportOutputName = null;
		if (loadConfig != null) {
			reportOutputName = loadConfig.getReportOutput();

			if (reportOutputName != null && !reportOutputName.isEmpty()) {

				for (int index = 0; index < reportOutputName.size(); index++) {
					if (reportName.equalsIgnoreCase(reportOutputName.get(index).getReportName())) {
						
						
						// Fetching the column Details of the Report
						columnParameter = loadConfig.getReportOutput().get(index).getColumnParameter();

					}
					if (columnParameter != null && !columnParameter.isEmpty()) {

						for (int i = 0; i < columnParameter.size(); i++) {
							rowHeading.createCell(i).setCellValue(columnParameter.get(i).getTitleName());
							sheet.autoSizeColumn(i);
						}
					}

				}
			}
		}

		// Styling the Sheet
		for (int i = 0; i < columnParameter.size(); i++) {
			HSSFCellStyle style = workbook.createCellStyle();
			// define the background color.
			style.setBorderTop(BorderStyle.DOUBLE);
			style.setBorderBottom(BorderStyle.THIN);

			style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

			// data of the cell.
			// make it BOLD and give blue as the color

			HSSFFont font = workbook.createFont();
			font.setFontName(HSSFFont.FONT_ARIAL);
			font.setFontHeightInPoints((short) 10);
			font.setBold(true);
			font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
			HSSFColor colour = new HSSFColor();
			colour.getHexString();
			style.setFont(font);
			// We create a simple cell, set its value and apply the cell style
			rowHeading.getCell(i).setCellStyle(style);

		}

		generateSheetWithColumn.setColumnParameter(columnParameter);
		generateSheetWithColumn.setSheet(sheet);
		generateSheetWithColumn.setWorkbook(workbook);
		return generateSheetWithColumn;
	}

	public static <T> byte[] generateReport(int reportType, String reportName, List<T> reportData)
			throws NoSuchFieldException, SecurityException, IOException {
		
		
		try {
			if (reportType == 1) {
				// Sheet Gneration with Column
				GenerateSheetWithColumn generateSheet = null;
				//Generate Sheet as per Report
				generateSheet = ExcelReportGeneration.generateSheet(reportName);
				HSSFSheet sheet = generateSheet.getSheet();
				HSSFWorkbook workbook = generateSheet.getWorkbook();
				List<ColumnParameter> columnParameter = generateSheet.getColumnParameter();
										 String Target=AppDataConstants.CUSTOMERDETAILS_REPORT_LOCATION;
										return ExcelReportGeneration.generateReport(reportData, columnParameter, sheet, workbook,Target);
			}
			else if (reportType == 2) {
							//	PDFReportGeneration.pdfReport(reportData);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			//throw new AppDataResourceNotFoundException(AppDataErrorConstant.ERROR_IN_RETRIEVING);

		}
		return null;

	}

	
	
	/**
	 * The Class ExcelReportGeneration.
	 * This Method : Values added in the Excel
	 *
	 * @author TCS
	 */
	
	
	
	private static <T>  byte[] generateReport(List<T> reportData, List<ColumnParameter> columnParameter, HSSFSheet sheet,
			HSSFWorkbook workbook, String target) {

		int r = 1;
		for (T element : reportData) {
			Row row = sheet.createRow(r);
			Method[] methods = element.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (isGetter(method)) {
					try {
						Object obj = method.invoke(element);
						for (int index = 0; index < columnParameter.size(); index++) {
							if (method.getName().equalsIgnoreCase(columnParameter.get(index).getFieldName())) {
								Cell cell = row.createCell(index);
								cell.setCellValue(obj.toString());
							}
						}
					}

					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			r++;
		}
		// Saving the file

		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(target));
			workbook.write(out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			byte[] byteContent = ApplicationMgmtUtil.getByteContent(workbook);
			LOG.info("Report Generated Successfully");
			return byteContent;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isGetter(Method method) {
		// identify get methods
		if ((method.getName().startsWith("get"))) {
			return true;
		}
		return false;
	}

}
