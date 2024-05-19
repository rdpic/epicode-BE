package it.epicode.bookingManager.repository;

import it.epicode.bookingManager.entity.Booking;
import it.epicode.bookingManager.entity.User;
import it.epicode.bookingManager.entity.Workstation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByWorkstationAndDate(Workstation workstation, LocalDate date);
    List<Booking> findByUserAndDate(User user, LocalDate date);
}
