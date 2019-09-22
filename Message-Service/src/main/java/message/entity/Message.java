package message.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import reaction.entity.Reaction;
import user.entity.User;


@Entity
@Table(name="APP_MESSAGE"
//		, uniqueConstraints=@UniqueConstraint(columnNames={"MsgID","Message"})
		)
//@JsonIgnoreProperties(value={"created_date","updated_date"})
public class Message implements Serializable {
	
	private static final long serialVersionUID=2L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, name="MsgID", length=5000)
	private long id;
	
	@Column(nullable=false, name="Message", length=5000)
	private String message;
	
	@Transient
	private String author;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(nullable=false, name="Created_Date")
	private Date created_date;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(nullable=true, name="Updated_Date")
	private Date updated_date;
	
	@JsonIgnore
	@Column(nullable=false, name="Deleted")
	private char deleted;
	
	
	@Column(name = "Privacy")
	@JsonProperty("visibility")
	private Privacy messagePrivacy;
	
	@JsonIgnore
	@ManyToOne(targetEntity=User.class,fetch=FetchType.LAZY)
	@JoinColumn(name="FK_AUTHOR_ID",nullable=false)
	private User user;
	
	@OneToMany(mappedBy="message")
	private Set<Reaction> reactions;
	
	public Set<Reaction> getReactions() {
		return reactions;
	}

	public void setReactions(Set<Reaction> reactions) {
		this.reactions = reactions;
	}

	public Privacy getMessagePrivacy() {
		return messagePrivacy;
	}

	public void setMessagePrivacy(Privacy messagePrivacy) {
		this.messagePrivacy = messagePrivacy;
	}

	public String getAuthor() {
		return user.getUserName();
		
	}

	public void setAuthor(User user) {
		this.author = user.getUserName();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User msgUser) {
		this.user = msgUser;
	}

	public Message(){
	}
	
	public Message(String message, String author, Date created_date, Date updated_date,
			String updated_by) {
		super();
		this.message = message;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.deleted = 'N';
	}
	
	public Message(String message, String author) {
		super();
		this.message = message;
		this.created_date = new Date();
		this.updated_date = null;
		this.deleted = 'N';
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long messageId) {
		this.id = messageId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}
	public char getDeleted() {
		return deleted ;
	}
	public void setDeleted(char isDeleted) {
		this.deleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + id + ", message=" + message + "]";
	}
	
	
	
}
