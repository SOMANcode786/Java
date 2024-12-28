package models;

import java.util.ArrayList;

public class student extends User {
    private ArrayList<Society> joinedSocieties;

    public student(String userID, String username, String password) {
        super(userID, username, password);
        this.joinedSocieties = new ArrayList<>();
    }

    public void joinSociety(Society society) {
        if (joinedSocieties.size() < 3) {
            joinedSocieties.add(society);
            System.out.println("Joined society: " + society.getName());
        } else {
            System.out.println("Cannot join more than 3 societies.");
        }
    }

	public void viewMemberships() {
		
		
	}
}
