package net.wei.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name = "user_detail")
//Model in flow scope needs to be serializable
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotBlank(message="Please enter first name.")
	private String firstName;	
	
	@Column(name = "last_name")
	@NotBlank(message="Please enter last name.")
	private String lastName;	
	
	@Column(name = "email")
	@NotBlank(message="Please enter email address.")
	private String email;
	
	@Column(name="phone")
	@NotBlank(message="Please enter phone.")
	private String phone;
	
	@Column(name="role")
	private String role;
	
	@Column(name="password")
	@NotBlank(message="Please enter password.")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled = true;
	
	//Don't store it in db
	@Transient
	private String confirmPassword;
	//---------------------------------------
						//should be field name //cascade operations
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	//The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations 
	//(PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
	private Cart cart;	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	//---------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phone=" + phone
				+ ", role=" + role + ", password=" + password + ", enabled="
				+ enabled + "]";
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	

	
	

}
