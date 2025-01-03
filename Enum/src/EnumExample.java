enum Level {
    LOW,
    MEDIUM,
    HARD
}

public class EnumExample {

    public static void main(String[] args) {
        Level l = Level.MEDIUM; // Assign a value to the enum variable

        // Switch statement with enum
        switch (l) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HARD:
                System.out.println("Hard level");
                break;
            default:
                System.out.println("Unknown level");
        }
    }
}
