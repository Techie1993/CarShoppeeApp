package com.example.payments;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.garage.GarageEntity;

@Entity
@Table(name="payments")
public class PaymentEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payid")
	private int payid;
	
	@Column(name="bookingid")
	private int bookid;

	
	@Column(name="garage_booked")
	private String gar_booked;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="aadharcard")
	private String aadharcard;
	
	@Column(name="book_amt")
	private int bookamt;
	
	@Column(name="pay_mode")
	private String mode;
	
	 @OneToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "garage_id", referencedColumnName = "gid")
	private GarageEntity garage;
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;
	
	@Column(name="uactivesw")
	private String activesw;
	
	
	public PaymentEntity() {
		System.out.println("Default...");
	}


	public PaymentEntity(int payid, int bookid, String gar_booked, String username, String aadharcard, int bookamt,
			String mode, GarageEntity garage, String activesw) {
		super();
		this.payid = payid;
		this.bookid = bookid;
		this.gar_booked = gar_booked;
		this.username = username;
		this.aadharcard = aadharcard;
		this.bookamt = bookamt;
		this.mode = mode;
		this.garage = garage;
		this.activesw = activesw;
	}


	public int getPayid() {
		return payid;
	}


	public void setPayid(int payid) {
		this.payid = payid;
	}


	public int getBookid() {
		return bookid;
	}


	public void setBookid(int bookid) {
		this.bookid = bookid;
	}


	public String getGar_booked() {
		return gar_booked;
	}


	public void setGar_booked(String gar_booked) {
		this.gar_booked = gar_booked;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getAadharcard() {
		return aadharcard;
	}


	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}


	public int getBookamt() {
		return bookamt;
	}


	public void setBookamt(int bookamt) {
		this.bookamt = bookamt;
	}


	public String getMode() {
		return mode;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}


	public GarageEntity getGarage() {
		return garage;
	}


	public void setGarage(GarageEntity garage) {
		this.garage = garage;
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


	public String getActivesw() {
		return activesw;
	}


	public void setActivesw(String activesw) {
		this.activesw = activesw;
	}


	@Override
	public String toString() {
		return "PaymentEntity [payid=" + payid + ", bookid=" + bookid + ", gar_booked=" + gar_booked + ", username="
				+ username + ", aadharcard=" + aadharcard + ", bookamt=" + bookamt + ", mode=" + mode + ", garage="
				+ garage + ", create=" + create + ", update=" + update + ", activesw=" + activesw + "]";
	}	
}
