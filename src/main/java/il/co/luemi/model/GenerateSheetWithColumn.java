package il.co.luemi.model;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import il.co.luemi.report.generation.ColumnParameter;

public class GenerateSheetWithColumn {
	private List<ColumnParameter> columnParameter;
	private HSSFSheet sheet;
	private HSSFWorkbook workbook;
	
	/**
	 * @return the columnParameter
	 */
	public List<ColumnParameter> getColumnParameter() {
		return columnParameter;
	}
	/**
	 * @param columnParameter the columnParameter to set
	 */
	public void setColumnParameter(List<ColumnParameter> columnParameter) {
		this.columnParameter = columnParameter;
	}
	/**
	 * @return the sheet
	 */
	public HSSFSheet getSheet() {
		return sheet;
	}
	/**
	 * @param sheet the sheet to set
	 */
	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}
	/**
	 * @return the workbook
	 */
	public HSSFWorkbook getWorkbook() {
		return workbook;
	}
	/**
	 * @param workbook the workbook to set
	 */
	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}
	
	
	

}
