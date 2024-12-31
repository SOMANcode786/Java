package entities;

import java.util.ArrayList;

public class Society {
    private String name;
    private String description;
    private ArrayList<Event> events;

    // Constructor
    public Society(String name, String description) {
        this.name = name;
        this.description = description;
        this.events = new ArrayList<>();
    }

    // Add an event to the society
    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event added: " + event.getName());
    }

    // List all events in the society
    public void listEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available for " + name);
        } else {
            System.out.println("Events for " + name + ":");
            for (Event event : events) {
                System.out.println("- " + event.getName() + " on " + event.getDate() + ": " + event.getDescription());
            }
        }
    }

    // Getters for encapsulation
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
