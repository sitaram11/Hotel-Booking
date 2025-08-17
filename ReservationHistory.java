import java.util.ArrayList;

public class ReservationHistory {
    private String username;
    private ArrayList<Hotel> bookedHotels = new ArrayList<>();

    public ReservationHistory(String username) {
        this.username = username;
    }

    public void addReservation(Hotel hotel) {
        bookedHotels.add(hotel);
    }

    public ArrayList<Hotel> getBookedHotels() {
        return bookedHotels;
    }
}
