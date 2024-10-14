package com.example;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogRecord;

public class Calculator {

    // Logger instance
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    // Custom Formatter to display only the message
    static class SimpleLogFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage() + "\n"; // Only display the log level and message
        }
    }

    static {
        try {
            // Remove any default handlers to prevent double logging
            Logger rootLogger = Logger.getLogger("");
            if (rootLogger.getHandlers().length > 0) {
                rootLogger.removeHandler(rootLogger.getHandlers()[0]);
            }

            // Set up the logger to log messages in a file
            FileHandler fileHandler = new FileHandler("calculator.log", true); // 'true' to append to the file
            fileHandler.setLevel(Level.ALL);

            // Use the custom formatter
            SimpleLogFormatter formatter = new SimpleLogFormatter();
            fileHandler.setFormatter(formatter);

            // Set up the logger to display log messages in the console
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            consoleHandler.setFormatter(formatter); // Use the same custom formatter for the console

            // Add the handlers to the logger
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

            // Set the logger level
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false); // Disable logging from parent handlers to avoid duplication
        } catch (IOException e) {
            logger.severe("Failed to set up FileHandler: " + e.getMessage());
        }
    }

    // Function to calculate square root
    public static double squareRoot(double x) {
        logger.info("Calculating square root for: " + x);
        if (x < 0) {
            logger.warning("Square root of a negative number is undefined.");
            return -1;
        }
        double result = Math.sqrt(x);
        logger.info("Square root result: " + result);
        return result;
    }

    // Function to calculate factorial
    public static long factorial(int x) {
        logger.info("Calculating factorial for: " + x);
        if (x < 0) {
            logger.warning("Factorial of a negative number is undefined.");
            return -1;
        }
        long fact = 1;
        for (int i = 2; i <= x; i++) {
            fact *= i;
        }
        logger.info("Factorial result: " + fact);
        return fact;
    }

    // Function to calculate natural logarithm (ln)
    public static double naturalLogarithm(double x) {
        logger.info("Calculating natural logarithm for: " + x);
        if (x <= 0) {
            logger.warning("Natural logarithm is undefined for zero or negative numbers.");
            return -1;
        }
        double result = Math.log(x);
        logger.info("Natural logarithm result: " + result);
        return result;
    }

    // Function to calculate power (x^y)
    public static double power(double base, double exponent) {
        logger.info("Calculating power for base: " + base + " and exponent: " + exponent);
        double result = Math.pow(base, exponent);
        logger.info("Power result: " + result);
        return result;
    }

    // Menu-driven program in the main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        logger.info("Scientific Calculator Program started.");

        while (true) {
            System.out.println("\nScientific Calculator Menu:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power (x^y)");
            System.out.println("5. Exit");

            System.out.print("Choose an option (1-5): ");
            choice = scanner.nextInt();

            logger.info("User selected option: " + choice);

            switch (choice) {
                case 1:
                    // Square Root
                    System.out.print("Enter a number: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("Square Root of " + num1 + " = " + squareRoot(num1));
                    break;

                case 2:
                    // Factorial
                    System.out.print("Enter a number: ");
                    int num2 = scanner.nextInt();
                    System.out.println("Factorial of " + num2 + " = " + factorial(num2));
                    break;

                case 3:
                    // Natural Logarithm
                    System.out.print("Enter a number: ");
                    double num3 = scanner.nextDouble();
                    System.out.println("Natural Logarithm of " + num3 + " = " + naturalLogarithm(num3));
                    break;

                case 4:
                    // Power
                    System.out.print("Enter the base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Enter the exponent: ");
                    double exponent = scanner.nextDouble();
                    System.out.println(base + "^" + exponent + " = " + power(base, exponent));
                    break;

                case 5:
                    // Exit
                    logger.info("Exiting the program.");
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    logger.warning("Invalid choice: " + choice);
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}

// Comment to test jenkins pipeline 