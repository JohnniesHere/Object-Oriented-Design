public class DivisionStrategy implements OperationStrategy {
    @Override
    public double execute(double firstOperand, double secondOperand) {
        if (secondOperand == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstOperand / secondOperand;
    }
}