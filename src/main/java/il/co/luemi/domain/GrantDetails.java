package il.co.luemi.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "GRANTDETAILS")
@NamedQuery(name = "GrantDetails.findAll", query = "SELECT a FROM GrantDetails a ORDER BY grantId")
public class GrantDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "GRANT_ID")
	private int grantId;
	@Column(name = "GRANT_CODE")
	private String grantCode;
	@Column(name = "GRANT_NAME")
	private String grantName;
	@Column(name = "GRANT_STATUS")
	private String grantStatus;
	@Column(name = "GRANT_TYPE")
	private String grantType;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	private Timestamp createdDate;
	@Column(name = "PENDING_DATE")
	private Timestamp pendingDate;
	/**
	 * @return the grantId
	 */
	public int getGrantId() {
		return grantId;
	}
	/**
	 * @param grantId the grantId to set
	 */
	public void setGrantId(int grantId) {
		this.grantId = grantId;
	}
	/**
	 * @return the grantCode
	 */
	public String getGrantCode() {
		return grantCode;
	}
	/**
	 * @param grantCode the grantCode to set
	 */
	public void setGrantCode(String grantCode) {
		this.grantCode = grantCode;
	}
	/**
	 * @return the grantName
	 */
	public String getGrantName() {
		return grantName;
	}
	/**
	 * @param grantName the grantName to set
	 */
	public void setGrantName(String grantName) {
		this.grantName = grantName;
	}
	/**
	 * @return the grantStatus
	 */
	public String getGrantStatus() {
		return grantStatus;
	}
	/**
	 * @param grantStatus the grantStatus to set
	 */
	public void setGrantStatus(String grantStatus) {
		this.grantStatus = grantStatus;
	}
	/**
	 * @return the grantType
	 */
	public String getGrantType() {
		return grantType;
	}
	/**
	 * @param grantType the grantType to set
	 */
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the pendingDate
	 */
	public Timestamp getPendingDate() {
		return pendingDate;
	}
	/**
	 * @param pendingDate the pendingDate to set
	 */
	public void setPendingDate(Timestamp pendingDate) {
		this.pendingDate = pendingDate;
	}
	
	
	
	
}
