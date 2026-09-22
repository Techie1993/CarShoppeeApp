package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.service.BookingServiceEntity;

@Entity
@Table(name="reg_users")
public class Registration {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private int uid;
	
	@Column(name="uname")
	private String uname;
	
	
	@Column(name="uemail",unique=true)
	private String uemail;
	
	@Column(name="umob",unique=true)
	private String umob;
	
	@Column(name="ustate")
	private String ustate;

	@Column(name="ucity")
	private String ucity;
	
	@Column(name="upass",unique=true)
	private String upass;
	
	@Column(name="uaadhar",unique=true)
	private String uaadhar;
	
	@Column(name="uactivesw")
	private String activesw;
	
	@Lob
	@Column(name="user_image")
	private byte[] image;
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;
	
	// One To One Mapping
    @OneToOne(mappedBy = "registration",
              cascade = CascadeType.ALL,
              fetch = FetchType.LAZY)
    private Editing editing;
	
    
    @OneToMany(mappedBy = "registration",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<BookingServiceEntity> bookings = new ArrayList<>();
	
	public Registration() {
		System.out.println("Default..");
	}

	public Registration(int uid, String uname, String uemail, String umob, String ustate, String ucity, String upass,
			String uaadhar, String activesw, byte[] image, Editing editing, List<BookingServiceEntity> bookings) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.umob = umob;
		this.ustate = ustate;
		this.ucity = ucity;
		this.upass = upass;
		this.uaadhar = uaadhar;
		this.activesw = activesw;
		this.image = image;
		this.editing = editing;
		this.bookings = bookings;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUmob() {
		return umob;
	}

	public void setUmob(String umob) {
		this.umob = umob;
	}

	public String getUstate() {
		return ustate;
	}

	public void setUstate(String ustate) {
		this.ustate = ustate;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getUaadhar() {
		return uaadhar;
	}

	public void setUaadhar(String uaadhar) {
		this.uaadhar = uaadhar;
	}

	public String getActivesw() {
		return activesw;
	}

	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public LocalDateTime getCreate() {
		return create;
	}

	public void setCreate(LocalDateTime create) {
		this.create = create;
	}

	public LocalDateTime getUpdate() {
		return update;
	}

	public void setUpdate(LocalDateTime update) {
		this.update = update;
	}

	public Editing getEditing() {
		return editing;
	}

	public void setEditing(Editing editing) {
		this.editing = editing;
	}

	public List<BookingServiceEntity> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingServiceEntity> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Registration [uid=" + uid + ", uname=" + uname + ", uemail=" + uemail + ", umob=" + umob + ", ustate="
				+ ustate + ", ucity=" + ucity + ", upass=" + upass + ", uaadhar=" + uaadhar + ", activesw=" + activesw
				+ ", image=" + Arrays.toString(image) + ", create=" + create + ", update=" + update + ", editing="
				+ editing + ", bookings=" + bookings + "]";
	}
}
