package com.example.chats;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.example.demo.Registration;

@Entity
@Table(name="chats")
public class ChatMessage {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="chatid")
	private int chatid;
	
	
	@ManyToOne
    @JoinColumn(name="uid")
    private Registration registration;
	
	
	@Column(name="sender")
	private String sender;

	@Column(name="message",length=1000)
	private String message;
	
	
	
	@CreationTimestamp
	@Column(name="createtime")
	private LocalDateTime messageTime;
	
	
	public ChatMessage() {
		System.out.println("Default....");
	}


	public ChatMessage(int chatid, Registration registration, String sender, String message,
			LocalDateTime messageTime) {
		super();
		this.chatid = chatid;
		this.registration = registration;
		this.sender = sender;
		this.message = message;
		this.messageTime = messageTime;
	}


	public int getChatid() {
		return chatid;
	}


	public void setChatid(int chatid) {
		this.chatid = chatid;
	}


	public Registration getRegistration() {
		return registration;
	}


	public void setRegistration(Registration registration) {
		this.registration = registration;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getMessageTime() {
		return messageTime;
	}


	public void setMessageTime(LocalDateTime messageTime) {
		this.messageTime = messageTime;
	}


	@Override
	public String toString() {
		return "ChatMessage [chatid=" + chatid + ", registration=" + registration + ", sender=" + sender + ", message="
				+ message + ", messageTime=" + messageTime + "]";
	}	
}
