package com.sandeep.login.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_register")
public class Register {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int auth_user_id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String status;
	public int getAuth_user_id() {
		return auth_user_id;
	}
	public void setAuth_user_id(int auth_user_id) {
		this.auth_user_id = auth_user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Register [auth_user_id=" + auth_user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}
	
	

}
