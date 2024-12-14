import java.io.IOException;
import java.util.List;

interface ShapeSerializer {
    void serialize(Shape shape, String filePath) throws IOException;
    void serializeAll(List<Shape> shapes, String filePath) throws IOException;
}