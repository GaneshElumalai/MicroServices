package user.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="APP_USER",uniqueConstraints=@UniqueConstraint(columnNames={"USER_ID","USER_NAME"}))
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long id;
	@Column(name="FIRST_NAME",nullable=false)
	private String firstName;
	@Column(name="LAST_NAME",nullable=true)
	private String lastName;
	@Column(name="MAIL_ID",nullable=false)
	private String mailId;
	@Column(name="PASSWORD",nullable=false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(name="USER_NAME",nullable=false)
	private String userName;
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "CREATED_DATE",nullable = false)
	private Date createdDate;
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(name = "UPDATED_DATE",nullable = false)
	private Date updatedDate;
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
