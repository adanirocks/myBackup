package il.co.luemi.response;

import com.mea.bpm.response.BaseResponse;

public class ReportGenerationResponse extends BaseResponse
{
	private byte[] reportData;

	/**
	 * @return the data
	 */
	public byte[] getreportData() {
		return reportData;
	}

	/**
	 * @param data the data to set
	 */
	public void setreportData(byte[] reportData) {
		this.reportData = reportData;
	}
	
	
	

}
