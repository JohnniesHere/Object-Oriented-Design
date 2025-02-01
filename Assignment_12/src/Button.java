public class Button {
    public enum Color {
        YELLOW, GREEN, BLUE
    }

    private Color color;
    private int[] location = new int[2];

    public Button(Color color) {
        this.color = color;
        location[0] = 0;
        location[1] = 0;
    }

    public Color getColor() {
        return color;
    }

    public void setLocation(int x, int y) {
        location[0] = x;
        location[1] = y;
    }

    public int[] getLocation() {
        return location;
    }

    public void display() {
        System.out.printf("Button color: %s, location: %d,%d%n",
            color, location[0], location[1]);
    }
}