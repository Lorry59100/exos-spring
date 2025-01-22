package spring.firststeps.exospring.EXO9;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.firststeps.exospring.EXO9.Class.Booking;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private List<Booking> bookingList = new ArrayList<>();
    private int id = 0;

    @PostMapping
    public ResponseEntity<String> addBooking(@RequestBody Booking booking) {
        id++;
        booking.setId(id);
        bookingList.add(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body("Réservation confirmée avec l'ID : " + id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        for (int i = 0; i < bookingList.size(); i++) {
            if(bookingList.get(i).getId() == id) {
                if(booking.getDate() == null) {
                    booking.setDate(bookingList.get(i).getDate());
                }
                if(booking.getRoom() == null) {
                    booking.setRoom(bookingList.get(i).getRoom());
                }
                bookingList.get(i).setRoom(booking.getRoom());
                bookingList.get(i).setDate(booking.getDate());
                return ResponseEntity.ok().body("Réservation mise à jour : " + bookingList.get(i).getRoom() + " date : " + bookingList.get(i).getDate());
            }
        }
        return ResponseEntity.status(404).body("Réservation non trouvée");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        for (int i = 0; i < bookingList.size(); i++) {
            if(bookingList.get(i).getId() == id) {
                bookingList.remove(i);
                return ResponseEntity.ok().body("Reservation supprimée");
            }
        }
        return ResponseEntity.status(404).body("Réservation non trouvée");
    }
}
