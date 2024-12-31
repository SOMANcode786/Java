package users;

public abstract class User {
    private String userID;
    private String username;
    private String password;

    // Constructor
    public User(String userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    // Encapsulated getters
    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    // Validate password
    public boolean validatePassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Abstract method to display role
    public abstract void displayRole();
}
