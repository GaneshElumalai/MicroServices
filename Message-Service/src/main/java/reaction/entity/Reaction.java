package reaction.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import message.entity.Message;
import user.entity.User;

@Entity
@Table(name="APP_REACTION")
public class Reaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "REACTED_USER_ID")
	private User user;
	
	@Transient
	private String reactedBy;
	
	private ReactionType reactionType;
	
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private Date reactedDate;
	
	@ManyToOne(targetEntity = Message.class)
	@JoinColumn(name = "REACTED_MSG_ID")
	@JsonIgnore
	private Message message;

	
	public String getReactedBy() {
		return user.getUserName();
	}

	public void setReactedBy(User user) {
		this.reactedBy = user.getUserName();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User reactedBy) {
		this.user = reactedBy;
	}

	public ReactionType getReactionType() {
		return reactionType;
	}

	public void setReactionType(ReactionType reactionType) {
		this.reactionType = reactionType;
	}

	public Date getReactedDate() {
		return reactedDate;
	}

	public void setReactedDate(Date reactedDate) {
		this.reactedDate = reactedDate;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message reactedMessage) {
		this.message = reactedMessage;
	}

	public Reaction(User reactedBy, ReactionType reactionType, Date reactedDate, Message reactedMessage) {
		super();
		this.user = reactedBy;
		this.reactionType = reactionType;
		this.reactedDate = reactedDate;
		this.message = reactedMessage;
	}
	
	public Reaction() {
		super();
	}
}
