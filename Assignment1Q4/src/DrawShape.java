class DrawShape {
    private char drawChar;

    public DrawShape(char drawChar) {
        this.drawChar = drawChar;
    }

    public void drawSquare(double length) {
        int len = (int) length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(drawChar + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void drawCircle(double radius) {
        int r = (int) radius;
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                if (Math.sqrt(i*i + j*j) <= r) {
                    System.out.print(drawChar + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void drawTriangle(double perpendicular, double base) {
        int height = (int) perpendicular;
        int width = (int) base;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= width/2 + i; j++) {
                if (j >= width/2 - i) {
                    System.out.print(drawChar + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
