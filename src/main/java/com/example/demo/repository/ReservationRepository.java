package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@Query(value = "SELECT r FROM Reservation r")
	List<Reservation> findAllReservation(Reservation reservation);
	
	@Query(value = " SELECT r FROM Reservation r where r.id=?1 ")
	Reservation findByReservationId(Long reservationid);

	@Query(value = " SELECT r FROM Reservation r where r.checkIn=?1")
	Reservation findByReservationDate(String checkIn);


}

