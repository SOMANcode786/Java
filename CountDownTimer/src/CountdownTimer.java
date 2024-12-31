import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {

    private int timeInSeconds;

    public CountdownTimer(int timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public void start() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (timeInSeconds > 0) {
                    System.out.println(formatTime(timeInSeconds));
                    timeInSeconds--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000); // Schedule task every 1 second
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input type:");
        System.out.println("1. Minutes");
        System.out.println("2. Seconds");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();

        int time = 0;
        if (choice == 1) {
            System.out.print("Enter countdown time in minutes: ");
            time = scanner.nextInt() * 60; // Convert minutes to seconds
        } else if (choice == 2) {
            System.out.print("Enter countdown time in seconds: ");
            time = scanner.nextInt();
        } else {
            System.out.println("Invalid choice! Exiting program.");
            System.exit(0);
        }

        CountdownTimer countdownTimer = new CountdownTimer(time);
        countdownTimer.start();
    }
}
