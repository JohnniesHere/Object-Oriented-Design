import java.util.ArrayList;
import java.util.List;

class ShapeCollection {
    private List<Shape> shapes;

    public ShapeCollection() {
        this.shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public double calculateTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        System.out.println("Total area of all shapes: " + totalArea);
        return totalArea;
    }

    public double calculateTotalPerimeter() {
        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.getPerimeter();
        }
        System.out.println("Total perimeter of all shapes: " + totalPerimeter);
        return totalPerimeter;
    }
}