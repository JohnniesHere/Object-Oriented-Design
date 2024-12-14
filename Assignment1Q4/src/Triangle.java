class Triangle implements Shape {
    private double perpendicular;
    private double base;
    private GeoCalculator calculator;
    private DrawShape drawer;

    public Triangle(double perpendicular, double base, GeoCalculator calculator, DrawShape drawer) {
        this.perpendicular = perpendicular;
        this.base = base;
        this.calculator = calculator;
        this.drawer = drawer;
    }

    @Override
    public double getArea() {
        return calculator.calculateTriangleArea(perpendicular, base);
    }

    @Override
    public double getPerimeter() {
        return calculator.calculateTrianglePerimeter(perpendicular, base);
    }

    @Override
    public void draw() {
        drawer.drawTriangle(perpendicular, base);
    }

    public double getBase() {
        return base;
    }

    public double getPerpendicular() {
        return perpendicular;
    }
}