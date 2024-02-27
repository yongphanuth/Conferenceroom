/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package roommanager;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomManager {
    private List<Room> allRooms;
    private List<Booking> bookings;
    private Admin admin;

    public RoomManager(String adminCode) {
        this.allRooms = new ArrayList<>();
        this.bookings = new ArrayList<>();
        this.admin = new Admin(adminCode);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
        System.out.println("Booking added successfully.");
    }

    public void displayBookings(User user) {
        System.out.println("Bookings for " + user.getUsername() + ":");
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getUser().getUsername().equals(user.getUsername())) {
                System.out.println("Room Number: " + booking.getRoom().getRoomNumber() +
                        ", Date Time: " + booking.getRoom().getDateTime() +
                        ", Shift: " + booking.getRoom().getShift());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bookings found for " + user.getUsername() + ".");
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : allRooms) {
            if (!isRoomBooked(room)) {
                System.out.println("Room Number: " + room.getRoomNumber());
            }
        }
    }

    public void displayUnavailableRooms() {
        System.out.println("Unavailable Rooms:");
        for (Room room : allRooms) {
            if (isRoomBooked(room)) {
                System.out.println("Room Number: " + room.getRoomNumber());
            }
        }
    }

    public void addRoom(Room room) {
        allRooms.add(room);
        System.out.println("Room added successfully.");
    }

    public void deleteRoom(int roomNumber) {
        for (Room room : allRooms) {
            if (room.getRoomNumber() == roomNumber) {
                allRooms.remove(room);
                System.out.println("Room deleted successfully.");
                return;
            }
        }
        System.out.println("Room not found.");
    }

    public boolean exitAdminMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter admin code to exit admin mode:");
        String inputCode = scanner.nextLine().trim();

        if (admin.verifyAdmin(inputCode)) {
            System.out.println("Admin mode exited successfully.");
            return true;
        } else {
            System.out.println("Invalid admin code. Unable to exit admin mode.");
            return false;
        }
    }

    public boolean cancelBooking(User user, int roomNumber) {
        for (Booking booking : bookings) {
            if (booking.getUser().getUsername().equals(user.getUsername()) && 
                booking.getRoom().getRoomNumber() == roomNumber) {
                bookings.remove(booking);
                System.out.println("Booking canceled successfully.");
                return true;
            }
        }
        System.out.println("No booking found for the specified room and user.");
        return false;
    }

    private boolean isRoomBooked(Room room) {
        for (Booking booking : bookings) {
            if (booking.getRoom().getRoomNumber() == room.getRoomNumber()) {
                return true;
            }
        }
        return false;
    }

    public Room findRoom(int roomNumber) {
        for (Room room : allRooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }
}
