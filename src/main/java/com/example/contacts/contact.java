package com.example.contacts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class contact {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conid;

	
	@Column(name="name")
	private String name;
	
	
	@Column(name="email")
	private String email;
	
	
	@Lob
	@Column(name="message")
	private String message;
	
	public contact() {
		System.out.println("Default...");
	}

	public contact(int conid, String name, String email, String message) {
		super();
		this.conid = conid;
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public int getConid() {
		return conid;
	}

	public void setConid(int conid) {
		this.conid = conid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "contact [conid=" + conid + ", name=" + name + ", email=" + email + ", message=" + message + "]";
	}
	
	
	
}
