import java.util.List;

public class ShapeCalculator {
    public static double calculateTotalArea(List<Shape> shapes) {
        double totalArea = shapes.stream()
                .mapToDouble(Shape::getArea)
                .sum();
        System.out.println("Total area of all shapes: " + totalArea);
        return totalArea;
    }

    public static double calculateTotalPerimeter(List<Shape> shapes) {
        double totalPerimeter = shapes.stream()
                .mapToDouble(Shape::getPerimeter)
                .sum();
        System.out.println("Total perimeter of all shapes: " + totalPerimeter);
        return totalPerimeter;
    }
}
