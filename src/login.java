import java.util.Scanner;

public class login {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=============== LOGIN =================");

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        System.out.println("You entered Account: " + accountNumber);
        System.out.println("Login attempt completed.");
    }
}
