import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;
public class RentalService {
    private LinkedList<ActiveRental> activeRentalsList = new LinkedList<>();

    public void startRental(String bikeID, String email) {
        ActiveRental rental = new ActiveRental(bikeID, email, LocalDateTime.now());
        activeRentalsList.add(rental);
        System.out.println("Reserving bike: " + bikeID);
    }

    public void endRental(String bikeID) {
        Iterator<ActiveRental> it = activeRentalsList.iterator();
        while (it.hasNext()) {
            ActiveRental r = it.next();
            if (r.getBikeID().equals(bikeID)) {
                it.remove();
                break;
            }
        }
        System.out.println("Your trip has ended.");
    }

    public void viewActiveRentals() {
        if (activeRentalsList.isEmpty()) {
            System.out.println("No active rentals.");
            return;
        }
        for (ActiveRental r : activeRentalsList) {
            System.out.println(r);
        }
    }
}