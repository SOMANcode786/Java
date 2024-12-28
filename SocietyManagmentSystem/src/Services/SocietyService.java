
package Services;

import models.*;

public class SocietyService {
    public void createSociety(Administrator admin, Society society) {
        if (admin.getSocieties().size() < 50) {
            admin.getSocieties().add(society);
            System.out.println("Society created: " + society.getName());
        } else {
            System.out.println("Cannot create more societies. Maximum limit reached.");
        }
    }

    public void displaySocieties(Administrator admin) {
        if (admin.getSocieties().isEmpty()) {
            System.out.println("No societies available.");
        } else {
            System.out.println("Societies:");
            for (Society society : admin.getSocieties()) {
                System.out.println("- " + society.getName());
            }
        }
    }

    public void approveMembership(Administrator admin, student student, Society society) {
        if (admin.getSocieties().contains(society)) {
            student.joinSociety(society);
            System.out.println("Membership approved for " + student.getUsername() + " in " + society.getName());
        } else {
            System.out.println("Society not found. Approval failed.");
        }
    }

	public Society findSocietyByName(String societyToJoin) {
		
		return null;
	}

	public boolean deleteSociety(Administrator admin, String societyToDelete) {
		// TODO Auto-generated method stub
		return false;
	}
}
