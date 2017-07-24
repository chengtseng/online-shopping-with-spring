package net.wei.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	//----------------------------------------
	
	@ManyToOne
	private User user;	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//----------------------------------------
	@Column(name="address_line_one")
	@NotBlank(message="Please enter your addrss line 1.")
	private String addressLineOne;
	@Column(name="address_line_two")
	private String addressLineTwo;
	@NotBlank(message="Please enter the city.")
	private String city;
	@NotBlank(message="Please enter the state.")
	private String state;
	@NotBlank(message="Please enter the country.")
	private String country;
	@Column(name="zip_code")
	@NotBlank(message="Please enter the zip code.")
	private String zipCode;
	private boolean shipping;
	private boolean billing;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddressLineOne() {
		return addressLineOne;
	}


	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}


	public String getAddressLineTwo() {
		return addressLineTwo;
	}


	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public boolean isShipping() {
		return shipping;
	}


	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}


	public boolean isBilling() {
		return billing;
	}


	public void setBilling(boolean billing) {
		this.billing = billing;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + user.getId() + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", zipCode=" + zipCode + ", shipping=" + shipping
				+ ", billing=" + billing + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
