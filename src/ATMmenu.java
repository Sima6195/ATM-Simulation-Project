/*import java.util.Scanner;

public class ATMmenu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Please login or select from the menu.");

        while (running) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Login");
            System.out.println("2. Check Balance");
            System.out.println("3. Withdraw Cash");
            System.out.println("4. Deposit Cash");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Login selected.");
                    break;

                case 2:
                    System.out.println("Check Balance selected.");
                    break;

                case 3:
                    System.out.println("Withdraw Cash selected.");
                    break;

                case 4:
                    System.out.println("Deposit Cash selected.");
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1-5.");
            }
        }

        scanner.close();
    }
}*/