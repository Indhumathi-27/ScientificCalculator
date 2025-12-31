import java.util.*;
import java.text.DecimalFormat;

public class ScientificCalculator {

    static List<String> history = new ArrayList<>();

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static long factorial(int num) {
        if (num == 0 || num == 1) return 1;
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] ones = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };

        StringBuilder word = new StringBuilder();

        if (num >= 1000) {
            word.append(ones[num / 1000]).append(" Thousand ");
            num %= 1000;
        }
        if (num >= 100) {
            word.append(ones[num / 100]).append(" Hundred ");
            num %= 100;
        }
        if (num >= 20) {
            word.append(tens[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            word.append(ones[num]);
        }

        return word.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        DecimalFormat df = new DecimalFormat("#.####");

        while (!exit) {
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power (x^y)");
            System.out.println("6. Square Root");
            System.out.println("7. Factorial");
            System.out.println("8. Prime Check");
            System.out.println("9. Trigonometry (sin, cos, tan)");
            System.out.println("10. Logarithms (log10, ln)");
            System.out.println("11. Number to Words");
            System.out.println("12. View History");
            System.out.println("13. Exit");

            System.out.print("Enter your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    if (scanner.hasNextDouble()) {
                        double a1 = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            double a2 = scanner.nextDouble();
                            double add = a1 + a2;
                            System.out.println("Result: " + add);
                            history.add("Addition: " + a1 + " + " + a2 + " = " + add);
                        } else {
                            System.out.println("Invalid second number!");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid first number!");
                        scanner.next();
                    }
                    break;

                case 2:
                    System.out.print("Enter two numbers: ");
                    if (scanner.hasNextDouble()) {
                        double s1 = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            double s2 = scanner.nextDouble();
                            double sub = s1 - s2;
                            System.out.println("Result: " + sub);
                            history.add("Subtraction: " + s1 + " - " + s2 + " = " + sub);
                        } else {
                            System.out.println("Invalid second number!");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid first number!");
                        scanner.next();
                    }
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    if (scanner.hasNextDouble()) {
                        double m1 = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            double m2 = scanner.nextDouble();
                            double mul = m1 * m2;
                            System.out.println("Result: " + mul);
                            history.add("Multiplication: " + m1 + " * " + m2 + " = " + mul);
                        } else {
                            System.out.println("Invalid second number!");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid first number!");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    if (scanner.hasNextDouble()) {
                        double d1 = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            double d2 = scanner.nextDouble();
                            if (d2 != 0) {
                                double div = d1 / d2;
                                System.out.println("Result: " + df.format(div));
                                history.add("Division: " + d1 + " / " + d2 + " = " + df.format(div));
                            } else {
                                System.out.println("Error: Division by zero.");
                            }
                        } else {
                            System.out.println("Invalid second number!");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid first number!");
                        scanner.next();
                    }
                    break;

                case 5:
                    System.out.print("Enter base and exponent: ");
                    if (scanner.hasNextDouble()) {
                        double base = scanner.nextDouble();
                        if (scanner.hasNextDouble()) {
                            double exp = scanner.nextDouble();
                            double pow = Math.pow(base, exp);
                            System.out.println("Result: " + pow);
                            history.add("Power: " + base + " ^ " + exp + " = " + pow);
                        } else {
                            System.out.println("Invalid exponent!");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid base!");
                        scanner.next();
                    }
                    break;

                case 6:
                    System.out.print("Enter number: ");
                    if (scanner.hasNextDouble()) {
                        double num = scanner.nextDouble();
                        if (num >= 0) {
                            System.out.println("Square Root: " + df.format(Math.sqrt(num)));
                            history.add("Sqrt(" + num + ") = " + df.format(Math.sqrt(num)));
                        } else {
                            System.out.println("Error: Cannot calculate square root of a negative number.");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 7:
                    System.out.print("Enter number: ");
                    if (scanner.hasNextInt()) {
                        int f = scanner.nextInt();
                        if (f >= 0) {
                            long fact = factorial(f);
                            System.out.println("Factorial: " + fact);
                            history.add("Factorial of " + f + " = " + fact);
                        } else {
                            System.out.println("Error: Factorial is not defined for negative numbers.");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 8:
                    System.out.print("Enter number: ");
                    if (scanner.hasNextInt()) {
                        int p = scanner.nextInt();
                        boolean prime = isPrime(p);
                        String res = prime ? "is Prime" : "is Not Prime";
                        System.out.println(p + " " + res);
                        history.add(p + " " + res);
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 9:
                    System.out.print("Enter angle in degrees: ");
                    if (scanner.hasNextDouble()) {
                        double angle = scanner.nextDouble();
                        double radians = Math.toRadians(angle);
                        System.out.println("sin(" + angle + ") = " + df.format(Math.sin(radians)));
                        System.out.println("cos(" + angle + ") = " + df.format(Math.cos(radians)));
                        System.out.println("tan(" + angle + ") = " + df.format(Math.tan(radians)));
                        history.add("Trig: sin(" + angle + ")=" + df.format(Math.sin(radians)) + 
                                    ", cos=" + df.format(Math.cos(radians)) +
                                    ", tan=" + df.format(Math.tan(radians)));
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 10:
                    System.out.print("Enter a number: ");
                    if (scanner.hasNextDouble()) {
                        double logInput = scanner.nextDouble();
                        if (logInput > 0) {
                            System.out.println("log10(" + logInput + ") = " + df.format(Math.log10(logInput)));
                            System.out.println("ln(" + logInput + ") = " + df.format(Math.log(logInput)));
                            history.add("Log: log10(" + logInput + ")=" + df.format(Math.log10(logInput)) + 
                                        ", ln=" + df.format(Math.log(logInput)));
                        } else {
                            System.out.println("Error: Input must be > 0.");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 11:
                    System.out.print("Enter an integer (0–9999): ");
                    if (scanner.hasNextInt()) {
                        int number = scanner.nextInt();
                        if (number >= 0 && number <= 9999) {
                            String words = numberToWords(number);
                            System.out.println("In Words: " + words);
                            history.add(number + " in words: " + words);
                        } else {
                            System.out.println("Number out of range!");
                        }
                    } else {
                        System.out.println("Invalid input!");
                        scanner.next();
                    }
                    break;

                case 12:
                    System.out.println("\n--- Calculation History ---");
                    if (history.isEmpty()) {
                        System.out.println("No history yet.");
                    } else {
                        for (String entry : history) {
                            System.out.println(entry);
                        }
                    }
                    break;

                case 13:
                    exit = true;
                    System.out.println("Exiting calculator...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}