package com.example.demo.controller;

//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Blocked;
import com.example.demo.model.Reservation;
import com.example.demo.service.BlockedServiceImpl;
import com.example.demo.service.ReservationServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ReservationController {
	
	@Autowired
	private ReservationServiceImpl reservaionService;
	
	@Autowired
	private BlockedServiceImpl blockedService;
	
	@PostMapping("/")
	public Reservation createReservation(@RequestBody Reservation reservation) {
		return reservaionService.createReservation(reservation);
	}	

	@GetMapping("/")
	public List<Blocked> ListAllBlocked(@RequestBody(required = false) Blocked blocked) {
		return blockedService.findAllBlockedDates(blocked);
	}
	
}

