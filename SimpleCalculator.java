import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = 0, num2 = 0;
        char operator = ' '; 
        boolean validInput = false;
  
        while (!validInput) {
            try {
                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(scanner.next());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        validInput = false;
        while (!validInput) {
            System.out.print("Enter an operation (+, -, *, /): ");
            String input = scanner.next();
            if (input.length() == 1) {  
                operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    validInput = true;
                } else {
                    System.out.println("Invalid operator! Please enter +, -, *, or /.");
                }
            } else {
                System.out.println("Invalid operator! Please enter a single character (+, -, *, or /).");
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.next());

                if (operator == '/' && num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed. Enter a non-zero number.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }

        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        System.out.println("Result: " + result);

        scanner.close();
    }
}

