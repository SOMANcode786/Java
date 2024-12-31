package users;

import entities.Society;

public class Administrator extends User {
    private Society[] societies; // Array to store societies
    private int societyCount;    // Counter for added societies

    public Administrator(String userID, String username, String password) {
        super(userID, username, password);
        this.societies = new Society[50]; // Maximum 50 societies
        this.societyCount = 0;
    }

    // Add a society
    public void addSociety(Society society) {
        if (societyCount < societies.length) {
            societies[societyCount++] = society;
            System.out.println("Society added: " + society.getName());
        } else {
            System.out.println("Cannot add more societies. Maximum limit reached.");
        }
    }

    // Delete a society
    public void deleteSociety(String societyName) {
        boolean found = false;
        for (int i = 0; i < societyCount; i++) {
            if (societies[i].getName().equalsIgnoreCase(societyName)) {
                for (int j = i; j < societyCount - 1; j++) {
                    societies[j] = societies[j + 1];
                }
                societies[--societyCount] = null;
                System.out.println("Society deleted: " + societyName);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Society not found: " + societyName);
        }
    }

    // List all societies
    public void listSocieties() {
        if (societyCount == 0) {
            System.out.println("No societies available.");
        } else {
            System.out.println("Societies:");
            for (int i = 0; i < societyCount; i++) {
                System.out.println("- " + societies[i].getName());
            }
        }
    }

    // **Find society by name**
    public Society findSocietyByName(String societyName) {
        for (int i = 0; i < societyCount; i++) {
            if (societies[i].getName().equalsIgnoreCase(societyName)) {
                return societies[i];
            }
        }
        return null; // Return null if society is not found
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Administrator");
    }
}
