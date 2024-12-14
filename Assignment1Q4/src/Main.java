import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GeoCalculator calculator = new GeoCalculator();
        DrawShape drawer = new DrawShape('*');


        Square square = new Square(5, calculator, drawer);
        Circle circle = new Circle(4, calculator, drawer);
        Triangle triangle = new Triangle(3, 5, calculator, drawer);

        System.out.println("Square:");
        System.out.println("Area: " + square.getArea());
        System.out.println("Perimeter: " + square.getPerimeter());
        square.draw();


        System.out.println("Circle:");
        System.out.println("Area: " + circle.getArea());
        System.out.println("Perimeter: " + circle.getPerimeter());
        circle.draw();


        System.out.println("Triangle:");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        triangle.draw();

            try {
                // Create shapes
                Square square1 = new Square(6, calculator, drawer);
                Circle circle1 = new Circle(6, calculator, drawer);
                Triangle triangle1 = new Triangle(3, 9, calculator, drawer);

                List<Shape> shapes = Arrays.asList(square, circle, triangle);

                // Create serializer
                ShapeSerializer serializer = new JSONShapeSerializer();

                // Serialize single shape
                serializer.serialize(square, "square.json");

                // Serialize all shapes
                serializer.serializeAll(shapes, "all_shapes.json");

            } catch (IOException e) {
                System.err.println("Error while serializing shapes: " + e.getMessage());
            }
        }
    }
