package il.co.luemi.report.generation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReportGeneration")
/*@XmlAccessorType(XmlAccessType.PROPERTY)*/
public class ReportGeneration {

	private int id;
    private List<ReportOutput> ReportOutput;
	
	
	public ReportGeneration() {
		
	}

	
 
	public ReportGeneration(int id, List<il.co.luemi.report.generation.ReportOutput> reportOutput) {
		super();
		this.id = id;
		ReportOutput = reportOutput;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportGeneration [id=" + id + ", ReportOutput=" + ReportOutput + "]";
	}



	@XmlElement(name="Id")
	int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the reportOutputName
	 */


	/**
	 * @return the reportOutputName
	 */
	@XmlElement(name="ReportOutputName")
	public List<ReportOutput> getReportOutput() {
		return ReportOutput;
	}

	/**
	 * @param reportOutputName the reportOutputName to set
	 */
	public void setReportOutput(List<ReportOutput> reportOutputName) {
		ReportOutput = reportOutputName;
	}

}
