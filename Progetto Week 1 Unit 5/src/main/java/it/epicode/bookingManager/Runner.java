package it.epicode.bookingManager;

import it.epicode.bookingManager.entity.Booking;
import it.epicode.bookingManager.entity.Building;
import it.epicode.bookingManager.entity.User;
import it.epicode.bookingManager.entity.Workstation;
import it.epicode.bookingManager.enums.WorkstationType;
import it.epicode.bookingManager.service.BookingService;
import it.epicode.bookingManager.service.BuildingService;
import it.epicode.bookingManager.service.UserService;
import it.epicode.bookingManager.service.WorkstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@PropertySource("application.properties")
public class Runner implements CommandLineRunner {

    @Autowired
    private BuildingService buildingService;
    @Autowired
    private WorkstationService workstationService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @Override
    public void run(String... args) throws Exception {

        Building building1 = new Building();
        building1.setName("Building A");
        building1.setAddress("Via Brombeis 222");
        building1.setCity("Naples");
        buildingService.save(building1);

        Building building2 = new Building();
        building2.setName("Building B");
        building2.setAddress("Via Del Corso 111");
        building2.setCity("Rome");
        buildingService.save(building2);

        Workstation ws1 = new Workstation();
        ws1.setCode("WS001");
        ws1.setDescription("Private Office");
        ws1.setWorkstationType(WorkstationType.PRIVATE);
        ws1.setMaxOccupants(1);
        ws1.setBuilding(building1);
        workstationService.save(ws1);

        Workstation ws2 = new Workstation();
        ws2.setCode("WS002");
        ws2.setDescription("Open Space Desk");
        ws2.setWorkstationType(WorkstationType.OPEN_SPACE);
        ws2.setMaxOccupants(1);
        ws2.setBuilding(building2);
        workstationService.save(ws2);

        User user1 = new User();
        user1.setUsername("riccardo_dp");
        user1.setFullName("Riccardo Del Piccolo");
        user1.setEmail("riccardodelpiccolo1@gmail.com");
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("sergio_dp");
        user2.setFullName("Sergio Del Piccolo");
        user2.setEmail("sergiodelpiccolo2@gmail.com");
        userService.save(user2);

        createBooking(ws1, user1, LocalDate.now());
        createBooking(ws2, user2, LocalDate.now().plusDays(1));

        System.out.println("All Workstations:");
        List<Workstation> workstations = workstationService.findAll();
        workstations.forEach(System.out::println);

        System.out.println("Search Workstations in Naples with type PRIVATE:");
        List<Workstation> searchResults = workstationService.findByTypeAndCity(WorkstationType.PRIVATE, "Naples");
        searchResults.forEach(System.out::println);
    }

    private void createBooking(Workstation workstation, User user, LocalDate date) {
        Booking booking = new Booking();
        booking.setWorkstation(workstation);
        booking.setUserr(user);
        booking.setDate(date);
        bookingService.save(booking);
    }

}
