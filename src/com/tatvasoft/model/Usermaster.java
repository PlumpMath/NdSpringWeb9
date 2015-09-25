package com.tatvasoft.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="user_master")

public class Usermaster {

	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="USERID", unique = true , nullable = false)
	private int userid;
	
	@Size(min=2,max=10)
	@Column(name = "FIRSTNAME")
	private String firstname;
	
	@NotEmpty(message="*")
	@Column(name = "LASTNAME")
	private String lastname;
	

	@Column(name = "ACTIVE")
	private boolean active;
	
	
	@NotNull
	@Min(1) @Max(3)
	@Column(name = "ROLEID")
	private int roleid;
	
	@NotEmpty(message="*")
	@Column(name = "PASSWORD")
	private String password;
	
	
	@NotEmpty(message="*")
	@Column(name = "USERNAME")
	private String username;
		
	private static String strtdt;
	
	private static String enddt;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static String getStrtdt() {
		return strtdt;
	}
	public static void setStrtdt(String strtdt) {
		Usermaster.strtdt = strtdt;
	}
	public static String getEnddt() {
		return enddt;
	}
	public static void setEnddt(String enddt) {
		Usermaster.enddt = enddt;
	}
}
