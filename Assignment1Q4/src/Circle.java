class Circle implements Shape {
    private double radius;
    private GeoCalculator calculator;
    private DrawShape drawer;

    public Circle(double radius, GeoCalculator calculator, DrawShape drawer) {
        this.radius = radius;
        this.calculator = calculator;
        this.drawer = drawer;
    }

    @Override
    public double getArea() {
        return calculator.calculateCircleArea(radius);
    }

    @Override
    public double getPerimeter() {
        return calculator.calculateCirclePerimeter(radius);
    }

    @Override
    public void draw() {
        drawer.drawCircle(radius);
    }

    public double getRadius() {
        return radius;
    }
}