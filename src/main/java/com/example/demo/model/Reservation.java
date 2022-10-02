package com.example.demo.model;

//import java.time.Date;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationid", nullable = false, updatable = false)
	private Long id;

	@Column(name = "checkIn")
	private String checkIn;

	@Column(name = "checkOut")
	private String checkOut;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "number")
	private String number;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Blocked> blocked;
  
  public Reservation(Long id, String checkIn, String checkOut, String firstName, String lastName, String number,
			String email, String address, List<Blocked> blocked) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
		this.address = address;
		this.blocked = blocked;
	}

	public List<Blocked> getBlocked() {
		return blocked;
	}

	public void setBlocked(List<Blocked> blocked) {
		this.blocked = blocked;
	}

	
	public Reservation(Long id, String checkIn, String checkOut, String firstName, String lastName, String number,
			String email, String address) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.email = email;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNumber() {
		return number;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Reservation() {

	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkIn=" + checkIn + ", checkOut=" + checkOut + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", number=" + number + ", email=" + email + ", address=" + address + "]";
	}

}
