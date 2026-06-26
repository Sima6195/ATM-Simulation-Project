import java.util.Scanner;


public class ATMmenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Please insert card or select from menu");

        while (running) {
            System.out.println("ATM menu");

            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            /*if(choice == 1) {
                System.out.println("Checking Balance");}
               else if (choice == 2){
              System.out.println("Enter amount to withdraw");}
                  else  if (choice == 3){
                    System.out.println("Enter account number");}
                       else if (choice == 4){
                       System.out.println("Thank you and Goodbye");}
            else {
                System.out.println("Invalid choice. Please choose 1-4.");} */
            switch (choice) {
                case 1:
                    System.out.println("Checking Balance");
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw");
                    break;

                case 3:
                    System.out.println("Enter account number");
                    break;

                case 4:
                    System.out.println("Thank you and Goodbye");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1-4.");
                    break;
            }

            running=false;
                        }
                    }
                }
