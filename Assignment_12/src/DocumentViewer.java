public class DocumentViewer {
    public static void main(String[] args) {
        TextDocument doc = new TextDocument();

        System.out.println("Initial writes:");
        doc.write("Hello");
        doc.print();
        doc.write(" World");
        doc.print();
        doc.write(" Today");
        doc.print();

        System.out.println("\nDemonstrating UNDO (3 times):");
        doc.undo();
        doc.print();  // Should show: "Hello World"
        doc.undo();
        doc.print();  // Should show: "Hello"
        doc.undo();
        doc.print();  // Should show: ""

        System.out.println("\nDemonstrating REDO (2 times):");
        doc.redo();
        doc.print();  // Should restore: "Hello"
        doc.redo();
        doc.print();  // Should restore: "Hello World"

        System.out.println("\nAdding new content after REDO:");
        doc.write(" Again");
        doc.print();  // Should show: "Hello World Again"
    }
}