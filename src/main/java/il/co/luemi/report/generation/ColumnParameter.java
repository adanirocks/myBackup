package il.co.luemi.report.generation;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "Column")
/*@XmlAccessorType(XmlAccessType.PROPERTY)*/
public class ColumnParameter {

	public ColumnParameter() {}
	private String titleName;
	private String fieldName;
	private String headerAlign;
	private String dataAlign;
	
	public ColumnParameter(String titleName, String fieldName, String headerAlign, String dataAlign) {
		super();
		this.titleName = titleName;
		this.fieldName = fieldName;
		this.headerAlign = headerAlign;
		this.dataAlign = dataAlign;
	}
	@Override
	public String toString() {
		return "ColumnParameter [titleName=" + titleName + ", fieldName=" + fieldName + ", headerAlign=" + headerAlign
				+ ", dataAlign=" + dataAlign + "]";
	}
	@XmlAttribute(name="TitleName")
	public String getTitleName() {
		return titleName;
	}
	/**
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	/**
	 * @return the fieldName
	 */
	@XmlAttribute(name="FieldName")
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the headerAlign
	 */
	@XmlAttribute(name="HeaderAlign")
	public String getHeaderAlign() {
		return headerAlign;
	}
	/**
	 * @param headerAlign the headerAlign to set
	 */
	public void setHeaderAlign(String headerAlign) {
		this.headerAlign = headerAlign;
	}
	/**
	 * @return the dataAlign
	 */
	@XmlAttribute(name="DataAlign")
	public String getDataAlign() {
		return dataAlign;
	}
	/**
	 * @param dataAlign the dataAlign to set
	 */
	public void setDataAlign(String dataAlign) {
		this.dataAlign = dataAlign;
	}
	
}