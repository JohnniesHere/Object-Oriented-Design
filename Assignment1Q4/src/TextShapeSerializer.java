import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class TextShapeSerializer implements ShapeSerializer {
    @Override
    public void serialize(Shape shape, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(createShapeText(shape));
        }
    }

    @Override
    public void serializeAll(List<Shape> shapes, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Shape shape : shapes) {
                writer.write(createShapeText(shape));
                writer.write("\n-------------------\n");
            }
        }
    }

    private String createShapeText(Shape shape) {
        StringBuilder text = new StringBuilder();
        text.append("Shape Type: ").append(shape.getClass().getSimpleName()).append("\n");
        text.append("Area: ").append(shape.getArea()).append("\n");
        text.append("Perimeter: ").append(shape.getPerimeter()).append("\n");

        if (shape instanceof Square) {
            Square square = (Square) shape;
            text.append("Length: ").append(square.getLength());
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            text.append("Radius: ").append(circle.getRadius());
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            text.append("Base: ").append(triangle.getBase()).append("\n");
            text.append("Perpendicular: ").append(triangle.getPerpendicular());
        }

        return text.toString();
    }
}