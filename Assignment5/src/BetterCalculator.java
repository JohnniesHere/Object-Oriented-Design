import java.security.InvalidParameterException;

public class BetterCalculator implements ICalculator {
    @Override
    public void calculate(IOperation operation) {
        if(operation == null) {
            throw new InvalidParameterException("Operation cannot be null");
        }

        if (operation instanceof Operation) {
            ((Operation) operation).calculateResult();
        }
    }
}