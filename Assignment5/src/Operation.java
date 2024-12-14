public class Operation implements IOperation {
    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;
    private final OperationStrategy strategy;

    public Operation(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public Operation(OperationStrategy strategy, double firstOperand, double secondOperand) {
        this.strategy = strategy;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    @Override
    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    @Override
    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public double getResult() {
        return result;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void calculateResult() {
        this.result = strategy.execute(firstOperand, secondOperand);
    }
}