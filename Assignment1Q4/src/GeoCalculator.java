class GeoCalculator {
    public double calculateSquareArea(double length) {
        return length * length;
    }

    public double calculateSquarePerimeter(double length) {
        return 4 * length;
    }

    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public double calculateTriangleArea(double perpendicular, double base) {
        return (base * perpendicular) / 2;
    }

    public double calculateTrianglePerimeter(double perpendicular, double base) {
        // Assuming isosceles triangle
        double hypotenuse = Math.sqrt(Math.pow(perpendicular, 2) + Math.pow(base/2, 2));
        return base + 2 * hypotenuse;
    }
}