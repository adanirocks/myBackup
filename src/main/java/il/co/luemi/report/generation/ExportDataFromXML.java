package il.co.luemi.report.generation;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


public class ExportDataFromXML {
	
	public <T> void generateReport(List<T> report, List<ColumnParameter> columnParameter,HSSFSheet sheet,HSSFWorkbook workbook)  {
		
		int r =1;
		for (T element : report)
		{
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

					catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			r++;
		}
	}
		
	
	private static boolean isGetter(Method method) {
		// identify get methods
		if ((method.getName().startsWith("get"))) {
			return true;
		}
		return false;
	}
	}

	


