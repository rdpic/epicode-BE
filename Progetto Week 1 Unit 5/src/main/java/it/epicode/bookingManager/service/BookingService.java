package it.epicode.bookingManager.service;

import it.epicode.bookingManager.entity.Booking;
import it.epicode.bookingManager.entity.Workstation;
import it.epicode.bookingManager.entity.User;
import it.epicode.bookingManager.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void deleteById(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> findByWorkstationAndDate(Workstation workstation, LocalDate date) {
        return bookingRepository.findByWorkstationAndDate(workstation, date);
    }

    public List<Booking> findByUserAndDate(User user, LocalDate date) {
        return bookingRepository.findByUserAndDate(user, date);
    }
}