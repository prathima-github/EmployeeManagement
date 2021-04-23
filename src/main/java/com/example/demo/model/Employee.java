package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable=false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String jobTitle;
	private String phoneNo;
	private String imageUrl;
	@Column(nullable=false, updatable = false)
	private String empCode;

	public Employee() {
	}

	public Employee(String name, String email, String jobTitle, String phoneNo, String imageUrl, String empCode) {
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phoneNo = phoneNo;
		this.imageUrl = imageUrl;
		this.empCode = empCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", jobTitle='" + jobTitle + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", empCode='" + empCode + '\'' +
				'}';
	}
}
