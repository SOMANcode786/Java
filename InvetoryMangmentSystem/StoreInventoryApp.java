import java.util.Scanner; // Import statement must be at the top

// StoreItem class to represent an item in the inventory
class StoreItem {
    String name;
    String code;
    double price;
    int quantity;

    StoreItem(String name, String code, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Code: " + code + ", Price: $" + price + ", Quantity: " + quantity;
    }
}

// StoreInventory class to manage items
class StoreInventory {
    StoreItem[] items;
    int itemCount;

    StoreInventory(int size) {
        items = new StoreItem[size];
        itemCount = 0;
    }

    void addItem(StoreItem item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
            System.out.println("Item added successfully!");
        } else {
            System.out.println("Inventory is full. Cannot add more items.");
        }
    }

    StoreItem searchItem(String code) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].code.equals(code)) {
                return items[i];
            }
        }
        return null;
    }

    void updateQuantity(String code, int newQuantity) {
        StoreItem item = searchItem(code);
        if (item != null) {
            item.quantity = newQuantity;
            System.out.println("Quantity updated successfully!");
        } else {
            System.out.println("Item not found.");
        }
    }

    void displayItems() {
        if (itemCount == 0) {
            System.out.println("No items in inventory.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(items[i]);
            }
        }
    }
}

// Main class to run the program
public class StoreInventoryApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StoreInventory inventory = new StoreInventory(5); // Fixed size for simplicity

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. Search Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Display Items");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice;

            // Validate user input
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter price: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid price. Please enter a valid number.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid quantity. Please enter a valid integer.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventory.addItem(new StoreItem(name, code, price, quantity));
                    break;

                case 2:
                    System.out.print("Enter code to search: ");
                    String searchCode = scanner.nextLine();
                    StoreItem item = inventory.searchItem(searchCode);
                    if (item != null) {
                        System.out.println("Found: " + item);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter code to update: ");
                    String updateCode = scanner.nextLine();
                    System.out.print("Enter new quantity: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid quantity. Please enter a valid integer.");
                        scanner.next(); // Clear invalid input
                        continue;
                    }
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    inventory.updateQuantity(updateCode, newQuantity);
                    break;

                case 4:
                    inventory.displayItems();
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
