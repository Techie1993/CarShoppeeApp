package com.example.garage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import com.example.payments.PaymentEntity;
import com.example.service.BookingServiceEntity;

@Entity
@Table(name="garage")
public class GarageEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gid;
	
	@Column(name="garage_name")
    private String garageName;
	
	@Column(name="owner_name")
    private String owner;
	
	@Column(name="city")
    private String city;
	
	@Column(name="address")
    private String address;
	
	@Column(name="expereince")
    private int exp;
	
	@Column(name="services")
    private String services;

	
	@Column(name="garage_type")
    private String garageType;

	
	@Column(name="working_hrs")
    private String workingHrs;
	
	@Column(name="reg_num")
    private String regnum;
	
	@Column(name="gstnum")
    private String gstNum;
	
	@Column(name="bookingamt")
    private Integer bookamt;
	
	
	@Lob
	@Column(name = "address_image")
	private byte[] addressProof;
	
	@Column(name = "garage_desc",length=1000)
	private String description;
	
	@Column(name="status")
	private String activesw;
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;
	
	@OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GarageImages>gimages = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
	private List<BookingServiceEntity> bookings = new ArrayList<>();
	
	// OneToOne Mapping
    @OneToOne(mappedBy = "garage", cascade = CascadeType.ALL)
    private PaymentEntity payment;
	
	
	public GarageEntity() {
		System.out.println("Default...");
	}


	public GarageEntity(Integer gid, String garageName, String owner, String city, String address, int exp,
			String services, String garageType, String workingHrs, String regnum, String gstNum, Integer bookamt,
			byte[] addressProof, String description, String activesw, List<GarageImages> gimages,
			List<BookingServiceEntity> bookings, PaymentEntity payment) {
		super();
		this.gid = gid;
		this.garageName = garageName;
		this.owner = owner;
		this.city = city;
		this.address = address;
		this.exp = exp;
		this.services = services;
		this.garageType = garageType;
		this.workingHrs = workingHrs;
		this.regnum = regnum;
		this.gstNum = gstNum;
		this.bookamt = bookamt;
		this.addressProof = addressProof;
		this.description = description;
		this.activesw = activesw;
		this.gimages = gimages;
		this.bookings = bookings;
		this.payment = payment;
	}


	public Integer getGid() {
		return gid;
	}


	public void setGid(Integer gid) {
		this.gid = gid;
	}


	public String getGarageName() {
		return garageName;
	}


	public void setGarageName(String garageName) {
		this.garageName = garageName;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
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


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}


	public String getServices() {
		return services;
	}


	public void setServices(String services) {
		this.services = services;
	}


	public String getGarageType() {
		return garageType;
	}


	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}


	public String getWorkingHrs() {
		return workingHrs;
	}


	public void setWorkingHrs(String workingHrs) {
		this.workingHrs = workingHrs;
	}


	public String getRegnum() {
		return regnum;
	}


	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}


	public String getGstNum() {
		return gstNum;
	}


	public void setGstNum(String gstNum) {
		this.gstNum = gstNum;
	}


	public Integer getBookamt() {
		return bookamt;
	}


	public void setBookamt(Integer bookamt) {
		this.bookamt = bookamt;
	}


	public byte[] getAddressProof() {
		return addressProof;
	}


	public void setAddressProof(byte[] addressProof) {
		this.addressProof = addressProof;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getActivesw() {
		return activesw;
	}


	public void setActivesw(String activesw) {
		this.activesw = activesw;
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


	public List<GarageImages> getGimages() {
		return gimages;
	}


	public void setGimages(List<GarageImages> gimages) {
		this.gimages = gimages;
	}


	public List<BookingServiceEntity> getBookings() {
		return bookings;
	}


	public void setBookings(List<BookingServiceEntity> bookings) {
		this.bookings = bookings;
	}


	public PaymentEntity getPayment() {
		return payment;
	}


	public void setPayment(PaymentEntity payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "GarageEntity [gid=" + gid + ", garageName=" + garageName + ", owner=" + owner + ", city=" + city
				+ ", address=" + address + ", exp=" + exp + ", services=" + services + ", garageType=" + garageType
				+ ", workingHrs=" + workingHrs + ", regnum=" + regnum + ", gstNum=" + gstNum + ", bookamt=" + bookamt
				+ ", addressProof=" + Arrays.toString(addressProof) + ", description=" + description + ", activesw="
				+ activesw + ", create=" + create + ", update=" + update + ", gimages=" + gimages + ", bookings="
				+ bookings + ", payment=" + payment + "]";
	}

}
