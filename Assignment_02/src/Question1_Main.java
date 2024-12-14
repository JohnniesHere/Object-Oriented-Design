import java.util.Scanner;

public class Question1_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question1_TrianglePrint printer = new Question1_TrianglePrint();

        System.out.println("Enter triangle type (1 for RIGHT_ANGLE, 2 for ISOSCELES):");
        int triangleType = sc.nextInt();

        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the symbol that the triangle will be made of:");
        char symbol = sc.next().charAt(0);

        Question1_TriangleCalculator calculator;
        if (triangleType == 1) {
            calculator = new Question1_RightAngleCalc();
            System.out.println("\nRight Angle triangle:");
            printer.printRightAngle(rows, symbol);
        } else if (triangleType == 2) {
            calculator = new Question1_IsoscelesCalc();
            System.out.println("\nIsoceles triangle:");
            printer.printIsoscelesTriangle(rows, symbol);
        }else {
            System.out.println("Invalid triangle type");
            sc.close();
            return;
        }

        double base = rows;
        double height = rows;

        System.out.printf("Perimeter: %.2f%n", calculator.calculatePerimeter(base, height));
        System.out.printf("Area: %.2f%n", calculator.calculateArea(base, height));

        sc.close();
    }
}