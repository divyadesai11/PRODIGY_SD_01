package Task01;
import java.util.Scanner;

public class TemperatureConverter {

    // celsius conversions
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }

    // fahrenheit conversions
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double fahrenheitToKelvin(double f) {
        return (f - 32) * 5 / 9 + 273.15;
    }

    // kelvin conversions
    public static double kelvinToCelsius(double k) {
        return k - 273.15;
    }

    public static double kelvinToFahrenheit(double k) {
        return (k - 273.15) * 9 / 5 + 32;
    }

    public static void convert(double value, String unit) {
        switch (unit) {
            case "celsius":
                System.out.printf("%.2f°C = %.2f°F and %.2fK%n", value, 
                                  celsiusToFahrenheit(value), celsiusToKelvin(value));
                break;

            case "fahrenheit":
                System.out.printf("%.2f°F = %.2f°C and %.2fK%n", value,
                                  fahrenheitToCelsius(value), fahrenheitToKelvin(value));
                break;

            case "kelvin":
                System.out.printf("%.2fK = %.2f°C and %.2f°F%n", value,
                                  kelvinToCelsius(value), kelvinToFahrenheit(value));
                break;

            default:
                System.out.println("Invalid unit. Use Celsius, Fahrenheit, or Kelvin.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Conversion Program");
        System.out.print("Enter the temperature value: ");
        double value = sc.nextDouble();
        sc.nextLine();  
        System.out.print("Enter the unit (celsius, fahrenheit, kelvin): ");
        String unit = sc.nextLine();

        convert(value, unit);
        sc.close();
    }
}
