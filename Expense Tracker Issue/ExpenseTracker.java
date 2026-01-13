import java.util.*;
import java.time.LocalDate;

// Transaction class to store income/expense details
class Transaction {
    String type;        // Income or Expense
    String category;    // Food, Rent, etc.
    double amount;
    LocalDate date;

    Transaction(String type, String category, double amount, LocalDate date) {
        this.type = type;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }
}


// Main Expense Tracker class
public class ExpenseTracker {

    static ArrayList<Transaction> transactions = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transaction History");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addTransaction("Income");
                    break;
                case 2:
                    addTransaction("Expense");
                    break;
                case 3:
                    viewTransactions();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Thank you for using Expense Tracker!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method to add income or expense
    static void addTransaction(String type) {
        sc.nextLine(); // consume newline
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        LocalDate date = LocalDate.now();

        transactions.add(new Transaction(type, category, amount, date));
        System.out.println(type + " added successfully!");
    }

    // View all transactions
    static void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        System.out.println("\n--- Transaction History ---");
        for (Transaction t : transactions) {
            System.out.println(
                t.date + " | " +
                t.type + " | " +
                t.category + " | ₹" + t.amount
            );
        }
    }

    // Generate income, expense & balance report
    static void generateReport() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.type.equals("Income")) {
                totalIncome += t.amount;
            } else {
                totalExpense += t.amount;
            }
        }

        System.out.println("\n--- Financial Report ---");
        System.out.println("Total Income  : ₹" + totalIncome);
        System.out.println("Total Expense : ₹" + totalExpense);
        System.out.println("Balance       : ₹" + (totalIncome - totalExpense));
    }
}
