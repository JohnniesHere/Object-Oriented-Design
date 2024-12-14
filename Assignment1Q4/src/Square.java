class Square implements Shape {
    private double length;
    private GeoCalculator calculator;
    private DrawShape drawer;

    public Square(double length, GeoCalculator calculator, DrawShape drawer) {
        this.length = length;
        this.calculator = calculator;
        this.drawer = drawer;
    }

    @Override
    public double getArea() {
        return calculator.calculateSquareArea(length);
    }

    @Override
    public double getPerimeter() {
        return calculator.calculateSquarePerimeter(length);
    }

    @Override
    public void draw() {
        drawer.drawSquare(length);
    }

    public double getLength() {
        return length;
    }
}