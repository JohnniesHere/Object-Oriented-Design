public class Question1_IsoscelesCalc implements Question1_TriangleCalculator {
    @Override
    public double calculatePerimeter(double base, double height) {
        return base + (height * 2);
    }

    @Override
    public double calculateArea(double base, double height) {
        return (base * height) / 2;
    }

}
