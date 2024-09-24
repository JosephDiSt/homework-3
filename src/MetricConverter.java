import java.util.Scanner;

public class MetricConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Welcome to metric converter!");
        System.out.println("Please input your query. For example, 1 km = m.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            System.out.print("Enter conversion query: ");
            input = scanner.nextLine().toLowerCase();

            // how to exit the program
            if (input.equals("exit") || input.equals("-1")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // process the Converstion 
            processConversion(input);
        }

        scanner.close();
    }

    // how to handle conversions
    public static void processConversion(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 4 || !parts[2].equals("=")) {
            System.out.println("Invalid format. Please input in the format: 1 km = m");
            return;
        }

        double value;
        try {
            value = Double.parseDouble(parts[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please input a valid number.");
            return;
        }

        String fromUnit = parts[1];
        String toUnit = parts[3];

        switch (fromUnit + " " + toUnit) {
            case "kg lb":
                System.out.println(value + " kg is " + kgToLb(value) + " lb.");
                break;
            case "km mile":
                System.out.println(value + " km is " + kmToMile(value) + " mile.");
                break;
            case "mm inch":
                System.out.println(value + " mm is " + mmToInch(value) + " inch.");
                break;
            case "gram ounce":
                System.out.println(value + " gram is " + gramToOunce(value) + " ounces.");
                break;
            default:
                System.out.println("Conversion not handled. Try something like: 1 kg = lb");
        }
    }

    // Conversions
    public static double kgToLb(double kg) {
        return kg * 2.20462;
    }

    public static double kmToMile(double km) {
        return km * 0.621371;
    }

    public static double mmToInch(double mm) {
        return mm * 0.0393701;
    }

    public static double gramToOunce(double grams) {
        return grams * 0.035274;
    }
}