/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roommanager;

/**
 *
 * @author User
 */
public class Booking {
    private User user;
    private Room room;

    public Booking(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }
}
