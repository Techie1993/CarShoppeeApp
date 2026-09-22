package com.example.cars;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import com.example.sellers.SellersInfo;

@Entity
@Table(name="cardata")
public class CarEntity {
		
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carid;

	
	@Column(name="comp_name")
    private String companyName;
	
	@Column(name="car_name")
    private String carName;
	
	@Column(name="model")
    private String model;
	
	@Column(name="year")
    private Integer year;
	
	@Column(name="purchase_price")
    private Double purchasePrice;
	
	@Column(name="fuel_type")
    private String fuelType;
	
	@Column(name="dist_covered")
    private String distanceCovered;
	
	@Column(name="puc_stats")
    private String pucStatus;
	
	@Column(name="gear_trans")
    private String gearTransmission;
	
	@Column(name="gear_config")
    private String gearConfiguration;
	
	@Column(name="insurance")
    private String insurance;
	
	@Column(name="chassis_num")
    private String chassisNumber;
	
	@Column(name="eng_num")
    private String engineNumber;
	
	@Column(name="reg_num")
    private String registrationNumber;
	
	@Column(name="city")
    private String city;
	
	@Column(name="car_type")
    private String carType;
	
	@Column(name="statndards")
    private String emissionStandards;
	
	@Column(name="showroom")
    private String showroomName;
	
	@Column(name="description")
    private String description;
	
	
	@Column(name="status")
	private String activesw;
	
	@CreationTimestamp
	@Column(name="createdate")
	private LocalDateTime create;

	@CreationTimestamp
	@Column(name="updatedate")
	private LocalDateTime update;
	

    // 🔥 Seller Mapping (Many Cars → One Seller)
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellersInfo seller;

    // 🔥 Images Mapping (One Car → Many Images)
    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarImages>images = new ArrayList<>();

	public CarEntity() {
		System.out.println("Default....");
	}

	public CarEntity(Integer carid, String companyName, String carName, String model, Integer year,
			Double purchasePrice, String fuelType, String distanceCovered, String pucStatus, String gearTransmission,
			String gearConfiguration, String insurance, String chassisNumber, String engineNumber,
			String registrationNumber, String city, String carType, String emissionStandards, String showroomName,
			String description, String activesw, SellersInfo seller, List<CarImages> images) {
		super();
		this.carid = carid;
		this.companyName = companyName;
		this.carName = carName;
		this.model = model;
		this.year = year;
		this.purchasePrice = purchasePrice;
		this.fuelType = fuelType;
		this.distanceCovered = distanceCovered;
		this.pucStatus = pucStatus;
		this.gearTransmission = gearTransmission;
		this.gearConfiguration = gearConfiguration;
		this.insurance = insurance;
		this.chassisNumber = chassisNumber;
		this.engineNumber = engineNumber;
		this.registrationNumber = registrationNumber;
		this.city = city;
		this.carType = carType;
		this.emissionStandards = emissionStandards;
		this.showroomName = showroomName;
		this.description = description;
		this.activesw = activesw;
		this.seller = seller;
		this.images = images;
	}

	public Integer getCarid() {
		return carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDistanceCovered() {
		return distanceCovered;
	}

	public void setDistanceCovered(String distanceCovered) {
		this.distanceCovered = distanceCovered;
	}

	public String getPucStatus() {
		return pucStatus;
	}

	public void setPucStatus(String pucStatus) {
		this.pucStatus = pucStatus;
	}

	public String getGearTransmission() {
		return gearTransmission;
	}

	public void setGearTransmission(String gearTransmission) {
		this.gearTransmission = gearTransmission;
	}

	public String getGearConfiguration() {
		return gearConfiguration;
	}

	public void setGearConfiguration(String gearConfiguration) {
		this.gearConfiguration = gearConfiguration;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getChassisNumber() {
		return chassisNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getEmissionStandards() {
		return emissionStandards;
	}

	public void setEmissionStandards(String emissionStandards) {
		this.emissionStandards = emissionStandards;
	}

	public String getShowroomName() {
		return showroomName;
	}

	public void setShowroomName(String showroomName) {
		this.showroomName = showroomName;
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

	public SellersInfo getSeller() {
		return seller;
	}

	public void setSeller(SellersInfo seller) {
		this.seller = seller;
	}

	public List<CarImages> getImages() {
		return images;
	}

	public void setImages(List<CarImages> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "CarEntity [carid=" + carid + ", companyName=" + companyName + ", carName=" + carName + ", model="
				+ model + ", year=" + year + ", purchasePrice=" + purchasePrice + ", fuelType=" + fuelType
				+ ", distanceCovered=" + distanceCovered + ", pucStatus=" + pucStatus + ", gearTransmission="
				+ gearTransmission + ", gearConfiguration=" + gearConfiguration + ", insurance=" + insurance
				+ ", chassisNumber=" + chassisNumber + ", engineNumber=" + engineNumber + ", registrationNumber="
				+ registrationNumber + ", city=" + city + ", carType=" + carType + ", emissionStandards="
				+ emissionStandards + ", showroomName=" + showroomName + ", description=" + description + ", activesw="
				+ activesw + ", create=" + create + ", update=" + update + ", seller=" + seller + ", images=" + images
				+ "]";
	}

	
}
