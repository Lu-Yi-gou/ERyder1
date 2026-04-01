import java.time.LocalDateTime;
public class BikeService {
    private boolean locationValid;

    public String validateLocation(String location) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getLocation().equalsIgnoreCase(location) && bike.isAvailable()) {
                System.out.println("A bike is available at the location you requested.");
                locationValid = true;
                return bike.getBikeID();
            }
        }
        System.out.println("Sorry, no bikes available.");
        locationValid = false;
        return null;
    }
    public boolean reserveBike(String bikeID) {
        if (bikeID == null) return false;
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(false);
                bike.setLastUsedTime(LocalDateTime.now());
                return true;
            }
        }
        return false;
    }

    public void releaseBike(String bikeID) {
        for (Bike bike : BikeDatabase.bikes) {
            if (bike.getBikeID().equals(bikeID)) {
                bike.setAvailable(true);
                bike.setLastUsedTime(LocalDateTime.now());
                break;
            }
        }
    }

    public boolean isLocationValid() {
        return locationValid;
    }
}