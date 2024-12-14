import java.security.InvalidParameterException;

public class SimpleCalculator implements ICalculator {
    @Override
    public void calculate(IOperation operation) {
        if(operation == null) {
            throw new InvalidParameterException("Some message");
        }

        if(operation instanceof Addition) {
            Addition obj = (Addition) operation;
            obj.setResult(obj.getFirstOperand() + obj.getSecondOperand());
        } else if(operation instanceof Substraction) {
            Substraction obj = (Substraction) operation;
            obj.setResult(obj.getFirstOperand() - obj.getSecondOperand());
        }
    }
}
