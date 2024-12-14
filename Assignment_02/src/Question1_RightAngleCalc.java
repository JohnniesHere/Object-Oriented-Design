public class Question1_RightAngleCalc implements Question1_TriangleCalculator {

    @Override
    public double calculatePerimeter(double base, double height) {
        double hypotenuse = Math.sqrt(base*base + height*height);
        return base + height + hypotenuse;
    }

    @Override
    public double calculateArea(double base, double height) {
        return (base * height)/2;
    }
}
