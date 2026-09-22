package com.example.demo;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="editprofile")
public class Editing {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eid")
	private int eid;
	
	
	@Column(name="new_email",unique=true)
	private String newemail;
	
	@Column(name="new_pass",unique=true)
	private String newpass;
	
	@Column(name="new_name")
	private String newname;
	
	@Column(name="new_mob",unique=true)
	private String newmob;
	
	@Column(name="new_city")
	private String newcity;
	
	@Column(name="new_state")
	private String newstate;
	
	@Lob
	@Column(name="user_image")
	private byte[] image;
	

    @OneToOne
    @JoinColumn(name = "uid", referencedColumnName = "uid")
    private Registration registration;

    public Editing() {
    	System.out.println("Default");
    }

	public Editing(int eid, String newemail, String newpass, String newname, String newmob, String newcity,
			String newstate, byte[] image, Registration registration) {
		super();
		this.eid = eid;
		this.newemail = newemail;
		this.newpass = newpass;
		this.newname = newname;
		this.newmob = newmob;
		this.newcity = newcity;
		this.newstate = newstate;
		this.image = image;
		this.registration = registration;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getNewemail() {
		return newemail;
	}

	public void setNewemail(String newemail) {
		this.newemail = newemail;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getNewname() {
		return newname;
	}

	public void setNewname(String newname) {
		this.newname = newname;
	}

	public String getNewmob() {
		return newmob;
	}

	public void setNewmob(String newmob) {
		this.newmob = newmob;
	}

	public String getNewcity() {
		return newcity;
	}

	public void setNewcity(String newcity) {
		this.newcity = newcity;
	}

	public String getNewstate() {
		return newstate;
	}

	public void setNewstate(String newstate) {
		this.newstate = newstate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	@Override
	public String toString() {
		return "Editing [eid=" + eid + ", newemail=" + newemail + ", newpass=" + newpass + ", newname=" + newname
				+ ", newmob=" + newmob + ", newcity=" + newcity + ", newstate=" + newstate + ", image="
				+ Arrays.toString(image) + ", registration=" + registration + "]";
	}		
}
