package com.dxc.finalproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author CONAN
 *
 */
/**
 * @author CONAN
 *
 */
@Entity
@Table(name = "Customer")
public class Customer implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@Column(name="customercode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="customername")
	private String customername;

	@Column(name="birthday")
	private String birthday;
	
	@Column(name="sex")
	private boolean sex;
	
	@Column(name="phonenumber")
	private String phonenumber;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	
}
