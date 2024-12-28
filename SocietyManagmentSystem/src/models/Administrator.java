package models;

import java.util.ArrayList;

public class Administrator extends User {
    private ArrayList<Society> societies;

    public Administrator(String userID, String username, String password) {
        super(userID, username, password);
        this.societies = new ArrayList<>();
    }

    public ArrayList<Society> getSocieties() {
        return societies;
    }
}
