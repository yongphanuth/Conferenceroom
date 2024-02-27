/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roommanager;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'user' for user mode or 'admin' for admin mode:");
        String mode = scanner.nextLine().trim();

        if (mode.equalsIgnoreCase("user")) {
            // User Mode
            System.out.println("Enter your username:");
            String username = scanner.nextLine().trim();
            User user = new User(username);

            System.out.println("Welcome, " + user.getUsername() + "!");

            RoomManager roomManager = new RoomManager("admin123"); // Admin code assumed to be "admin123"

            // Example available rooms
            roomManager.addRoom(new Room(101, "2024-02-27 10:00", "Morning"));
            roomManager.addRoom(new Room(102, "2024-02-27 14:00", "Afternoon"));

            boolean userModeActive = true;
            while (userModeActive) {
                System.out.println("\nUser Options:");
                System.out.println("1. Show Available Rooms");
                System.out.println("2. Show Unavailable Rooms");
                System.out.println("3. Book a Room");
                System.out.println("4. Cancel Booking");
                System.out.println("5. Exit User Mode");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        roomManager.displayAvailableRooms();
                        break;
                    case 2:
                        roomManager.displayUnavailableRooms();
                        break;
                    case 3:
                        System.out.println("Enter the room number you want to book:");
                        int selectedRoomNumber = scanner.nextInt();
                        Room selectedRoom = roomManager.findRoom(selectedRoomNumber);
                        if (selectedRoom != null) {
                            Booking booking = new Booking(user, selectedRoom);
                            roomManager.addBooking(booking);
                        } else {
                            System.out.println("Invalid room number.");
                        }
                        break;
                    case 4:
                        System.out.println("Enter the room number you want to cancel booking for:");
                        int cancelRoomNumber = scanner.nextInt();
                        if (roomManager.cancelBooking(user, cancelRoomNumber)) {
                            System.out.println("Booking canceled successfully.");
                        } else {
                            System.out.println("Failed to cancel booking.");
                        }
                        break;
                    case 5:
                        userModeActive = false;
                        System.out.println("Exiting user mode.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else if (mode.equalsIgnoreCase("admin")) {
            // Admin Mode
            System.out.println("Enter admin code:");
            String adminCode = scanner.nextLine().trim();

            RoomManager roomManager = new RoomManager(adminCode);

            // Example available rooms
            roomManager.addRoom(new Room(101, "2024-02-27 10:00", "Morning"));
            roomManager.addRoom(new Room(102, "2024-02-27 14:00", "Afternoon"));

            boolean adminModeActive = true;
            while (adminModeActive) {
                System.out.println("\nAdmin Options:");
                System.out.println("1. Show Available Rooms");
                System.out.println("2. Show Unavailable Rooms");
                System.out.println("3. Add Room");
                System.out.println("4. Delete Room");
                System.out.println("5. Exit Admin Mode");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        roomManager.displayAvailableRooms();
                        break;
                    case 2:
                        roomManager.displayUnavailableRooms();
                        break;
                    case 3:
                        System.out.println("Enter room number:");
                        int roomNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter date time:");
                        String dateTime = scanner.nextLine().trim();
                        System.out.println("Enter shift:");
                        String shift = scanner.nextLine().trim();
                        Room room = new Room(roomNumber, dateTime, shift);
                        roomManager.addRoom(room);
                        break;
                    case 4:
                        System.out.println("Enter room number to delete:");
                        int roomNumberToDelete = scanner.nextInt();
                        roomManager.deleteRoom(roomNumberToDelete);
                        break;
                    case 5:
                        adminModeActive = !roomManager.exitAdminMode();
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Invalid mode.");
        }

        scanner.close();
    }
}
