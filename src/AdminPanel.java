import java.util.Scanner;

public class AdminPanel {
    private final UserService userService = new UserService();
    private final BikeService bikeService = new BikeService();
    private final RentalService rentalService = new RentalService();
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Remove User");
            System.out.println("4. Demo Bike Rental");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int c = scanner.nextInt();
            scanner.nextLine();

            if (c == 1) addUser();
            else if (c == 2) viewUsers();
            else if (c == 3) removeUser();
            else if (c == 4) demoRental();
            else if (c == 5) break;
        }
    }
    
    private void addUser() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        RegisteredUsers user = new RegisteredUsers(name, email);
        userService.addUser(user);
        System.out.println("User added.");
    }

    private void viewUsers() {
        for (RegisteredUsers u : userService.getAllUsers()) {
            System.out.println(u);
        }
    }

    private void removeUser() {
        System.out.print("Email to remove: ");
        userService.removeUser(scanner.nextLine());
    }

    private void demoRental() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Location: ");
        String location = scanner.nextLine();

        String bikeID = bikeService.validateLocation(location);
        if (!bikeService.isLocationValid()) return;

        bikeService.reserveBike(bikeID);
        rentalService.startRental(bikeID, email);
        rentalService.viewActiveRentals();

        rentalService.endRental(bikeID);
        bikeService.releaseBike(bikeID);
        rentalService.viewActiveRentals();
    }
}