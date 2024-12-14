public class Main {
    public static void main(String[] args) {
        ICalculator calculator = new BetterCalculator();

        // Test Addition
        IOperation addition = new Operation(new AdditionStrategy(), 10, 5);
        calculator.calculate(addition);
        System.out.println("Addition: " + addition.getResult()); // 15.0

        // Test Subtraction
        IOperation subtraction = new Operation(new SubtractionStrategy(), 10, 5);
        calculator.calculate(subtraction);
        System.out.println("Subtraction: " + subtraction.getResult()); // 5.0

        // Test Multiplication
        IOperation multiplication = new Operation(new MultiplicationStrategy(), 10, 5);
        calculator.calculate(multiplication);
        System.out.println("Multiplication: " + multiplication.getResult()); // 50.0

        // Test Division
        IOperation division = new Operation(new DivisionStrategy(), 10, 5);
        calculator.calculate(division);
        System.out.println("Division: " + division.getResult()); // 2.0

        // Test Division by zero
        try {
            IOperation divisionByZero = new Operation(new DivisionStrategy(), 10, 0);
            calculator.calculate(divisionByZero);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero caught successfully");
        }

        // Demonstrate changing operands
        IOperation reusableOperation = new Operation(new AdditionStrategy());
        reusableOperation.setFirstOperand(20);
        reusableOperation.setSecondOperand(30);
        calculator.calculate(reusableOperation);
        System.out.println("New Addition: " + reusableOperation.getResult()); // 50.0
    }
}