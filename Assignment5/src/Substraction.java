public class Substraction implements IOperation
{
    private double firstOperand;
    private double secondOperand;
    private double result = 0.0;

    public Substraction() {
    }


    public Substraction(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    //Setters and getters
    public double getFirstOperand() {
        return firstOperand;
    }


    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }


    public double getSecondOperand() {
        return secondOperand;
    }


    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }


    public double getResult() {
        return result;
    }


    @Override
    public void setResult(double result) {
        this.result = result;
    }


}
