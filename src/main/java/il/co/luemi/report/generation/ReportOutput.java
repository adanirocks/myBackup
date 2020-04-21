package il.co.luemi.report.generation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="ReportOutputName")
/*@XmlAccessorType(XmlAccessType.PROPERTY)*/
public class ReportOutput
{
	
	public ReportOutput() {
		super();
	}
	private String reportName;
	private String headerBgColor;
	private String dataBgColor;
	private List<ColumnParameter> columnParameter;
	
	
	
	
	public ReportOutput(String reportName, String headerBgColor, String dataBgColor,
			List<ColumnParameter> columnParameter) {
		super();
		this.reportName = reportName;
		this.headerBgColor = headerBgColor;
		this.dataBgColor = dataBgColor;
		this.columnParameter = columnParameter;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportOutput [reportName=" + reportName + ", headerBgColor=" + headerBgColor + ", dataBgColor="
				+ dataBgColor + ", columnParameter=" + columnParameter + "]";
	}



	/**
	 * @return the reportName
	 */
	@XmlAttribute(name = "name")
	public String getReportName() {
		return reportName;
	}
	/**
	 * @param reportName the reportName to set
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}



	/**
	 * @return the headerBgColor
	 */
	public String getHeaderBgColor() {
		return headerBgColor;
	}



	/**
	 * @param headerBgColor the headerBgColor to set
	 */
	@XmlAttribute(name = "HeaderBgColor")
	public void setHeaderBgColor(String headerBgColor) {
		this.headerBgColor = headerBgColor;
	}



	/**
	 * @return the dataBgColor
	 */
	@XmlAttribute(name = "DataBgColor")
	public String getDataBgColor() {
		return dataBgColor;
	}

	/**
	 * @param dataBgColor the dataBgColor to set
	 */
	public void setDataBgColor(String dataBgColor) {
		this.dataBgColor = dataBgColor;
	}
	/**
	 * @return the columnParameter
	 */
	@XmlElement(name = "Column")
	public List<ColumnParameter> getColumnParameter() {
		return columnParameter;
	}

	/**
	 * @param columnParameter the columnParameter to set
	 */
	public void setColumnParameter(List<ColumnParameter> columnParameter) {
		this.columnParameter = columnParameter;
	}
	
	
	

}
