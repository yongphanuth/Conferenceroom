/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roommanager;

/**
 *
 * @author User
 */
public class Room {
    private int roomNumber;
    private String dateTime;
    private String shift;

    public Room(int roomNumber, String dateTime, String shift) {
        this.roomNumber = roomNumber;
        this.dateTime = dateTime;
        this.shift = shift;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getShift() {
        return shift;
    }
}
