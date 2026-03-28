public class ERyder {
    public static final String COMPANY_NAME = "ERyder";
    public static final double BASE_FARE = 1.0;
    public static final double PER_MINUTE_FARE = 0.5;

    private final String LINKED_ACCOUNT;
    private final String LINKED_PHONE_NUMBER;

    private String bikeID;
    private int batteryLevel;
    private boolean isAvailable;
    private double kmDriven;

    private int totalUsageInMinutes;
    private double totalFare;

    public ERyder() {
        this.bikeID = "01";
        this.batteryLevel = 100;
        this.isAvailable = true;
        this.kmDriven = 0.0;
        this.LINKED_ACCOUNT = "default user";
        this.LINKED_PHONE_NUMBER = "000-0000-0000";
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven) {
        if (bikeID == null || bikeID.trim().isEmpty()) {
            throw new IllegalArgumentException("bikeID cannot be empty!");
        }
        this.setBatteryLevel(batteryLevel);
        if (kmDriven < 0) {
            throw new IllegalArgumentException("Driven kilometers cannot be negative!");
        }
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;

        this.LINKED_ACCOUNT = "default user";
        this.LINKED_PHONE_NUMBER = "000-0000-0000";
    }

    public ERyder(String bikeID, int batteryLevel, boolean isAvailable, double kmDriven,
                  String linkedAccount, String linkedPhoneNumber) {
        if (bikeID == null || bikeID.trim().isEmpty()) {
            throw new IllegalArgumentException("bikeID cannot be empty!");
        }
        this.setBatteryLevel(batteryLevel);
        if (kmDriven < 0) {
            throw new IllegalArgumentException("Driven kilometers cannot be negative!");
        }
        this.bikeID = bikeID;
        this.isAvailable = isAvailable;
        this.kmDriven = kmDriven;

        this.LINKED_ACCOUNT = linkedAccount;
        this.LINKED_PHONE_NUMBER = linkedPhoneNumber;
    }

    public void ride() {
        if (this.batteryLevel > 0 && this.isAvailable) {
            System.out.println("Ride Info: Bike " + this.bikeID + " is available, ready to ride!");
        } else {
            String reason = (this.batteryLevel <= 0) ? "battery depleted" : "bike occupied";
            System.out.println("Ride Info: Bike " + this.bikeID + " is unavailable! Reason: " + reason);
        }
    }

    public void printBikeDetails() {
        System.out.println("\n===== eRyder Bike Details =====");
        System.out.println("Bike ID: " + this.bikeID);
        System.out.println("Battery Level: " + this.batteryLevel + "%");
        System.out.println("Availability: " + (this.isAvailable ? "Available" : "Unavailable"));
        System.out.println("Total Distance Driven: " + String.format("%.2f", this.kmDriven) + " km");
        System.out.println("===============================");
    }

    public void printRideDetails(int usageInMinutes) {
        this.totalUsageInMinutes = usageInMinutes;
        this.totalFare = calculateFare(usageInMinutes);

        System.out.println("\n===== " + COMPANY_NAME + " Ride Receipt =====");
        System.out.println("Linked Account: " + this.LINKED_ACCOUNT);
        System.out.println("Linked Phone Number: " + this.LINKED_PHONE_NUMBER);
        System.out.println("Bike ID: " + this.bikeID);
        System.out.println("Total Usage Time: " + this.totalUsageInMinutes + " minutes");
        System.out.println("Total Fare: $" + String.format("%.2f", this.totalFare));
        System.out.println("==================================");
    }

    private double calculateFare(int usageInMinutes) {
        return BASE_FARE + (PER_MINUTE_FARE * usageInMinutes);
    }

    public String getBikeID() {
        return bikeID;
    }

    public void setBikeID(String bikeID) {
        if (bikeID == null || bikeID.trim().isEmpty()) {
            throw new IllegalArgumentException("bikeID can not be empty!");
        }
        this.bikeID = bikeID;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0 || batteryLevel > 100) {
            throw new IllegalArgumentException("Battery level must be between 0 and 100!");
        }
        this.batteryLevel = batteryLevel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(double kmDriven) {
        if (kmDriven < 0) {
            throw new IllegalArgumentException("Driven kilometers can not be negative!");
        }
        this.kmDriven = kmDriven;
    }
}