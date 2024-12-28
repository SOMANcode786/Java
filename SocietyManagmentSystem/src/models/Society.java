package models;

public class Society {
    private String societyID;
    private String name;
    private String description;

    public Society(String societyID, String name, String description) {
        this.societyID = societyID;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
}
