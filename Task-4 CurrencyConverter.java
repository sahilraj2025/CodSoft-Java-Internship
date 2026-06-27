package codsoft;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("      CURRENCY CONVERTER");
        System.out.println("=================================");
        System.out.println("\nAvailable Currencies:");
        System.out.println("1. INR (Indian Rupee)");
        System.out.println("2. USD (US Dollar)");
        System.out.println("3. EUR (Euro)");
        System.out.println("4. GBP (British Pound)");
        System.out.print("\nSelect Base Currency (1-4): ");
        int baseChoice = sc.nextInt();
        System.out.print("Select Target Currency (1-4): ");
        int targetChoice = sc.nextInt();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        String[] currencyNames = {"INR", "USD", "EUR", "GBP"};

        double[][] rates = {
                {1.0, 0.012, 0.011, 0.0095}, // INR
                {83.0, 1.0, 0.92, 0.79},     // USD
                {90.0, 1.09, 1.0, 0.86},     // EUR
                {105.0, 1.27, 1.16, 1.0}     // GBP
        };

        if (baseChoice < 1 || baseChoice > 4 ||
                targetChoice < 1 || targetChoice > 4) {

            System.out.println("\nInvalid Currency Selection!");
        } else {

            double exchangeRate =
                    rates[baseChoice - 1][targetChoice - 1];

            double convertedAmount = amount * exchangeRate;

            System.out.println("\n=================================");
            System.out.println("      CONVERSION RESULT");
            System.out.println("=================================");
            System.out.println("Base Currency   : " +
                    currencyNames[baseChoice - 1]);
            System.out.println("Target Currency : " +
                    currencyNames[targetChoice - 1]);
            System.out.println("Amount Entered  : " + amount);
            System.out.println("Exchange Rate   : " + exchangeRate);
            System.out.printf("Converted Amount: %.2f %s%n",
                    convertedAmount,
                    currencyNames[targetChoice - 1]);
            System.out.println("=================================");
        }

        sc.close();
    }
}