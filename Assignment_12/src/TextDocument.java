import java.util.Stack;

public class TextDocument {
    private String text = "";
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();
    private static final int MAX_HISTORY = 5;

    public void write(String text) {
        saveState();
        this.text += text;
        redoStack.clear(); // Clear redo stack when new text is written
    }

    public void print() {
        System.out.println(text);
    }

    public void saveState() {
        if (undoStack.size() >= MAX_HISTORY) {
            undoStack.removeElementAt(0);
        }
        undoStack.push(new Memento(text));
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(new Memento(text));
            text = undoStack.pop().getState();
            if (redoStack.size() > MAX_HISTORY) {
                redoStack.removeElementAt(0);
            }
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(new Memento(text));
            text = redoStack.pop().getState();
            if (undoStack.size() > MAX_HISTORY) {
                undoStack.removeElementAt(0);
            }
        }
    }
}