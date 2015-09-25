package com.tatvasoft.model;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role_master")
public class Rolemaster {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name= "ROLEID" , unique = true , nullable = false)
	private int roleid ;
	
	
	
	
	@Column(name= "ROLENAME")
	private String rolename;
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
