import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class JSONShapeSerializer implements ShapeSerializer {
    private String getShapeType(Shape shape) {
        return shape.getClass().getSimpleName();
    }

    @Override
    public void serialize(Shape shape, String filePath) throws IOException {
        String jsonShape = createShapeJSON(shape);
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonShape);
        }
    }

    @Override
    public void serializeAll(List<Shape> shapes, String filePath) throws IOException {
        StringBuilder jsonArray = new StringBuilder();
        jsonArray.append("[\n");

        for (int i = 0; i < shapes.size(); i++) {
            jsonArray.append(createShapeJSON(shapes.get(i)));
            if (i < shapes.size() - 1) {
                jsonArray.append(",");
            }
            jsonArray.append("\n");
        }

        jsonArray.append("]");

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonArray.toString());
        }
    }

    private String createShapeJSON(Shape shape) {
        StringBuilder json = new StringBuilder();
        json.append("  {\n");

        // Add common properties
        appendJsonProperty(json, "type", getShapeType(shape), true);
        appendJsonProperty(json, "area", shape.getArea(), true);

        // Add specific properties based on shape type
        if (shape instanceof Square) {
            Square square = (Square) shape;
            appendJsonProperty(json, "length", square.getLength(), true);
        } else if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            appendJsonProperty(json, "radius", circle.getRadius(), true);
        } else if (shape instanceof Triangle) {
            Triangle triangle = (Triangle) shape;
            appendJsonProperty(json, "base", triangle.getBase(), true);
            appendJsonProperty(json, "perpendicular", triangle.getPerpendicular(), true);
        }

        appendJsonProperty(json, "perimeter", shape.getPerimeter(), false);
        json.append("  }");

        return json.toString();
    }

    private void appendJsonProperty(StringBuilder json, String key, Object value, boolean addComma) {
        json.append("    \"").append(key).append("\": ");

        if (value instanceof String) {
            json.append("\"").append(value).append("\"");
        } else {
            json.append(value);
        }

        if (addComma) {
            json.append(",");
        }
        json.append("\n");
    }
}