package com.example.garage;

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
import com.example.cars.CarEntity;

@Entity
@Table(name="gar_images")
public class GarageImages {
		
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
    private GarageEntity garage;

    public GarageImages() {
    	System.out.println("Default..");
    }

	public GarageImages(Integer imageId, byte[] image, String fileName, String contentType, GarageEntity garage) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.fileName = fileName;
		this.contentType = contentType;
		this.garage = garage;
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

	public GarageEntity getGarage() {
		return garage;
	}

	public void setGarage(GarageEntity garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		return "GarageImages [imageId=" + imageId + ", image=" + Arrays.toString(image) + ", fileName=" + fileName
				+ ", contentType=" + contentType + ", garage=" + garage + "]";
	}
}
