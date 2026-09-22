package com.example.service;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.demo.Registration;
import com.example.garage.GarageEntity;

@Entity
@Table(name="servicebookings")
public class BookingServiceEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="servid")
	private int servid;
	
	@Column(name="user_name")
	private String username;
	
	
	@Column(name="uaadharcard")
	private String aadharcard;
	
	@Column(name="serviceopted")
	private String service;
	
	@Column(name="garagelist")
	private String garagelist;
	
	@Column(name="bookingamt")
	private int bookingamt;
	
	@Column(name="vehicle")
	private String vehname;
	
	@Column(name="veh_num")
	private String veh_num;
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;
	
	@Column(name="uactivesw")
	private String activesw;
	
	// Many Booking -> One Registration
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid") // Foreign Key
    private Registration registration;
	
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gid")
    private GarageEntity garage;
    
    
	public BookingServiceEntity() {
		System.out.println("Default...");
	}


	public BookingServiceEntity(int servid, String username, String aadharcard, String service, String garagelist,
			int bookingamt, String vehname, String veh_num, String activesw, Registration registration,
			GarageEntity garage) {
		super();
		this.servid = servid;
		this.username = username;
		this.aadharcard = aadharcard;
		this.service = service;
		this.garagelist = garagelist;
		this.bookingamt = bookingamt;
		this.vehname = vehname;
		this.veh_num = veh_num;
		this.activesw = activesw;
		this.registration = registration;
		this.garage = garage;
	}


	public int getServid() {
		return servid;
	}


	public void setServid(int servid) {
		this.servid = servid;
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


	public String getService() {
		return service;
	}


	public void setService(String service) {
		this.service = service;
	}


	public String getGaragelist() {
		return garagelist;
	}


	public void setGaragelist(String garagelist) {
		this.garagelist = garagelist;
	}


	public int getBookingamt() {
		return bookingamt;
	}


	public void setBookingamt(int bookingamt) {
		this.bookingamt = bookingamt;
	}


	public String getVehname() {
		return vehname;
	}


	public void setVehname(String vehname) {
		this.vehname = vehname;
	}


	public String getVeh_num() {
		return veh_num;
	}


	public void setVeh_num(String veh_num) {
		this.veh_num = veh_num;
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


	public Registration getRegistration() {
		return registration;
	}


	public void setRegistration(Registration registration) {
		this.registration = registration;
	}


	public GarageEntity getGarage() {
		return garage;
	}


	public void setGarage(GarageEntity garage) {
		this.garage = garage;
	}


	@Override
	public String toString() {
		return "BookingService [servid=" + servid + ", username=" + username + ", aadharcard=" + aadharcard
				+ ", service=" + service + ", garagelist=" + garagelist + ", bookingamt=" + bookingamt + ", vehname="
				+ vehname + ", veh_num=" + veh_num + ", create=" + create + ", update=" + update + ", activesw="
				+ activesw + ", registration=" + registration + ", garage=" + garage + "]";
	}


}
