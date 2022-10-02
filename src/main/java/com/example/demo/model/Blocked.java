package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@Table(name = "blocked")
public class Blocked {
	@Id
	@Column(name = "reservedDate")
	private String reservedDate;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn (name="reservationid",referencedColumnName="reservationid",nullable=false,unique=false)
	 @JsonIgnore
	private Reservation reservation;
	
	
	public Blocked() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blocked(String reservedDate, Reservation reservation) {
		super();
		this.reservedDate = reservedDate;
		this.reservation = reservation;
	}
	public String getReservedDate() {
		return reservedDate;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservedDate(String reservedDate) {
		this.reservedDate = reservedDate;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

	
}
