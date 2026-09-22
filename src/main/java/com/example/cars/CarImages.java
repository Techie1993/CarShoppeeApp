package com.example.cars;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carimages")
public class CarImages {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer imageId;

	    @Lob
	    @Column(columnDefinition = "LONGBLOB")
	    private byte[] image;

	    private String fileName;
	    private String contentType;

	    @ManyToOne
	    @JoinColumn(name = "gid")
	    private CarEntity car;

	    public CarImages() {
	    	System.out.println("Default...");
	    }

		public CarImages(Integer imageId, byte[] image, String fileName, String contentType, CarEntity car) {
			super();
			this.imageId = imageId;
			this.image = image;
			this.fileName = fileName;
			this.contentType = contentType;
			this.car = car;
		}

		public Integer getImageId() {
			return imageId;
		}

		public void setImageId(Integer imageId) {
			this.imageId = imageId;
		}

		public byte[] getImage() {
			return image;
		}

		public void setImage(byte[] image) {
			this.image = image;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getContentType() {
			return contentType;
		}

		public void setContentType(String contentType) {
			this.contentType = contentType;
		}

		public CarEntity getCar() {
			return car;
		}

		public void setCar(CarEntity car) {
			this.car = car;
		}

		@Override
		public String toString() {
			return "CarImages [imageId=" + imageId + ", fileName=" + fileName + ", contentType=" + contentType + "]";
		}
	}
	