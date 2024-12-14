public class Question1_TrianglePrint {

    public void printRightAngle(int rows, char symbol){
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    public void printIsoscelesTriangle(int rows, char symbol){
        for (int i = 1; i <= rows ; i++) {
            for (int j = 1; j <= rows - i ; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i -1); j++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
