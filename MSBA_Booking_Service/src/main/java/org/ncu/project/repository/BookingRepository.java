package org.ncu.project.repository;

import org.ncu.project.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	Booking findByBookingId(int bookingId);
}
