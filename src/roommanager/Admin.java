/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package roommanager;

/**
 *
 * @author User
 */
public class Admin {
    private String adminCode;

    public Admin(String adminCode) {
        this.adminCode = adminCode;
    }

    // Getter
    public String getAdminCode() {
        return adminCode;
    }

    // Method to verify admin credentials
    public boolean verifyAdmin(String inputCode) {
        return adminCode.equals(inputCode);
    }
}
