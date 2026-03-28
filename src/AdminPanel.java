import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminPanel {
    List<RegisteredUsers> registeredUsersList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void userManagementOptions() {
        while (true) {
            System.out.println("Welcome to E-Ryder Administrator Panel.");
            System.out.println("What do you want to do?");
            System.out.println("1. Add New Users");
            System.out.println("2. View Registered Users");
            System.out.println("3. Remove Registered Users");
            System.out.println("4. Update Registered Users");
            System.out.println("5. Demo the Bike Rental System");
            System.out.println("6. EXIT");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addNewUsers();
            } else if (choice == 2) {
                viewRegisteredUsers();
            } else if (choice == 3) {
                removeRegisteredUsers();
            } else if (choice == 4) {
                updateRegisteredUsers();
            } else if (choice == 5) {
                BikeRental bikeRental = new BikeRental();
                bikeRental.simulateApplicationInput();
            } else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewUsers() {
        System.out.print("How many users do you want to add: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < num; i++) {
            System.out.println("\nEnter details for user " + (i + 1));

            System.out.print("Full Name: ");
            String name = scanner.nextLine();

            System.out.print("Email Address: ");
            String email = scanner.nextLine();

            System.out.print("Date of Birth (YYYY-MM-DD): ");
            String dob = scanner.nextLine();

            System.out.print("Card Number: ");
            String card = scanner.nextLine();

            System.out.print("Card Expiry Date: ");
            String exp = scanner.nextLine();

            System.out.print("Card Provider: ");
            String provider = scanner.nextLine();

            System.out.print("CVV: ");
            String cvv = scanner.nextLine();

            System.out.print("User Type: ");
            String type = scanner.nextLine();

            String[] trips = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("\nEnter Trip " + (j + 1));
                System.out.print("Trip Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Source: ");
                String src = scanner.nextLine();
                System.out.print("Destination: ");
                String dest = scanner.nextLine();
                System.out.print("Fare: ");
                String fare = scanner.nextLine();
                System.out.print("Feedback: ");
                String feed = scanner.nextLine();

                StringBuilder sb = new StringBuilder();
                sb.append("Date: ").append(date)
                        .append(", Source: ").append(src)
                        .append(", Destination: ").append(dest)
                        .append(", Fare (€): ").append(fare)
                        .append(", Feedback: ").append(feed);

                trips[j] = sb.toString();
            }

            RegisteredUsers user = new RegisteredUsers(name, email, dob, card, exp, provider, cvv, type, trips);
            registeredUsersList.add(user);
            System.out.println("User added successfully!");
        }
    }

    private void viewRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to display");
            return;
        }

        for (RegisteredUsers u : registeredUsersList) {
            System.out.println("----------------------------------");
            System.out.println(u);
            System.out.println("----------------------------------");
        }
    }

    private void removeRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to remove");
            return;
        }

        System.out.print("Enter email to remove: ");
        String email = scanner.nextLine();
        boolean found = false;

        Iterator<RegisteredUsers> it = registeredUsersList.iterator();
        while (it.hasNext()) {
            RegisteredUsers u = it.next();
            if (u.getEmailAddress().equals(email)) {
                it.remove();
                found = true;
                System.out.println("User removed successfully!");
            }
        }

        if (!found) {
            System.out.println("No user found with this email address");
        }
    }

    private void updateRegisteredUsers() {
        if (registeredUsersList.isEmpty()) {
            System.out.println("No registered users to update");
            return;
        }

        System.out.print("Enter email to update: ");
        String email = scanner.nextLine();
        RegisteredUsers target = null;

        for (RegisteredUsers u : registeredUsersList) {
            if (u.getEmailAddress().equals(email)) {
                target = u;
                break;
            }
        }

        if (target == null) {
            System.out.println("No user found with this email address");
            return;
        }

        System.out.print("Type new full name (Press ENTER for no change): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            target.setFullName(name);
        }

        System.out.print("Type new email (Press ENTER for no change): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            target.setEmailAddress(newEmail);
        }

        System.out.print("Type new DOB (Press ENTER for no change): ");
        String dob = scanner.nextLine();
        if (!dob.isEmpty()) {
            target.setDateOfBirth(dob);
        }

        System.out.print("Type new card number (0 for no change): ");
        String card = scanner.nextLine();
        if (!card.equals("0")) {
            target.setCardNumber(card);
        }

        System.out.print("Type new expiry (Press ENTER for no change): ");
        String exp = scanner.nextLine();
        if (!exp.isEmpty()) {
            target.setCardExpiryDate(exp);
        }

        System.out.print("Type new provider (Press ENTER for no change): ");
        String pro = scanner.nextLine();
        if (!pro.isEmpty()) {
            target.setCardProvider(pro);
        }

        System.out.print("Type new CVV (0 for no change): ");
        String cvv = scanner.nextLine();
        if (!cvv.equals("0")) {
            target.setCvv(cvv);
        }

        System.out.print("Type new user type (Press ENTER for no change): ");
        String type = scanner.nextLine();
        if (!type.isEmpty()) {
            target.setUserType(type);
        }

        System.out.println("User updated successfully!");
    }
}