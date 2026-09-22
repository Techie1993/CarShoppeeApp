package com.example.sellers;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="sellers")
public class SellersInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sid")
	private int sid;
	
	@Column(name="seller_name")
	private String name;
	
	@Column(name="seller_email",unique=true)
	private String email;
	
	@Column(name="seller_mobile",unique=true)
	private String mobile;

	@Column(name="seller_aadhar_card",unique=true)
	private String aadharcard;
	
	@Lob
	@Column(name="seller_image")
	private byte[] image;
	
	@Transient
	private MultipartFile imageFile;
	@Column(name="seller_state")
	private String state;
	
	@Column(name="seller_city")
	private String city;
	
	
	@Column(name="seller_address",length=1000)
	private String address;
	
	
	@Column(name="seller_desc",length=1000)
	private String description;
	
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;

	public SellersInfo() {
		System.out.println("Default...");
	}

	public SellersInfo(int sid, String name, String email, String mobile, String aadharcard, byte[] image,
			MultipartFile imageFile, String state, String city, String address, String description) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.aadharcard = aadharcard;
		this.image = image;
		this.imageFile = imageFile;
		this.state = state;
		this.city = city;
		this.address = address;
		this.description = description;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public String toString() {
		return "SellersInfo [sid=" + sid + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", aadharcard=" + aadharcard + ", image=" + Arrays.toString(image) + ", imageFile=" + imageFile
				+ ", state=" + state + ", city=" + city + ", address=" + address + ", description=" + description
				+ ", create=" + create + ", update=" + update + "]";
	}
}
