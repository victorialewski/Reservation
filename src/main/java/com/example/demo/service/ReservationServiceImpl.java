package com.example.demo.service;

import java.util.*;
import java.util.stream.IntStream;
import java.util.Date.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Blocked;
import com.example.demo.model.Reservation;
import com.example.demo.repository.BlockedRepository;
import com.example.demo.repository.ReservationRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;


@Service
public class ReservationServiceImpl {
	
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private BlockedRepository blockedRepo;
	
	public Reservation createReservation (Reservation reservation) {
		 reservationRepo.save(reservation);	
		 this.insertBlockedDate(reservation.getId(),reservation.getCheckIn(), reservation.getCheckOut());
		 return reservation;		
	}
	
	//use this one
	public List <Blocked> insertBlockedDate(Long id, String checkIn, String checkOut) {
//		Reservation reservationId = this.findByReservationId(id);
		List<Blocked> result = new ArrayList<>();
		
		int blockedIdCount = 1; 

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        LocalDate startDate = LocalDate.parse(checkIn, formatter);
	        LocalDate endDate = LocalDate.parse(checkOut, formatter);
	        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
//	        	List<Blocked> result = blockedRepo.save(date.format(formatter));
	            result.add(new Blocked(date.format(formatter), findByReservationId(id)));
//	            result.add(new Blocked(blockedIdCount++,date.format(formatter), findByReservationId(id)));

	            System.out.println(" Date is ..." + result);	        }
		
		return blockedRepo.saveAll(result);
	}

	public Reservation findByReservationDate(String checkIn){
		return reservationRepo.findByReservationDate(checkIn);
	} 	
	public Reservation findByReservationId(Long reservationid){
		return reservationRepo.findByReservationId(reservationid);
	}

	    }

