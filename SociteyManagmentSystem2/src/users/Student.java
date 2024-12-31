package users;

import entities.Society;
import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Society> joinedSocieties;

    // Constructor
    public Student(String userID, String username) {
        super(userID, username, userID); // Student ID and password are the same
        joinedSocieties = new ArrayList<>();
    }

    // Method to join a society
    public void joinSociety(Society society) throws Exception {
        if (joinedSocieties.size() < 3) {
            joinedSocieties.add(society);
            System.out.println("Joined society: " + society.getName());
        } else {
            throw new Exception("Cannot join more than 3 societies.");
        }
    }

    // Method to list joined societies
    public void listJoinedSocieties() {
        if (joinedSocieties.isEmpty()) {
            System.out.println("No joined societies.");
        } else {
            System.out.println("Joined Societies:");
            for (Society society : joinedSocieties) {
                System.out.println("- " + society.getName());
            }
        }
    }

    // Getter for joined societies
    public ArrayList<Society> getJoinedSocieties() {
        return new ArrayList<>(joinedSocieties); // Return a copy for immutability
    }

    // Validate the student ID (same as password)
    public boolean validateUniversityID(String studentID) {
        return this.getUserID().equals(studentID);
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
}
