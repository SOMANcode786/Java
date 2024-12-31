package entities;

public class Event {
    private String name;
    private int day;
    private int month;
    private int year;
    private String description;

    // Constructor
    public Event(String name, int day, int month, int year, String description) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
    }

    // Getters for encapsulation
    public String getName() {
        return name;
    }

    public String getDate() {
        return day + "/" + month + "/" + year;
    }

    public String getDescription() {
        return description;
    }
}

