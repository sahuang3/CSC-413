import java.util.*;

public class Main {

    static int xPos;
    static int yPos;

    // 100x100 so there's no ArrayIndexOutOfBounds error
    static String[][] display = new String[100][100];

    public static void main(String[] args) {

        // Assigning 100x100 with blank spaces
        for(int i = 0; i<100; i++){
            for( int j = 0; j<100; j++){
                display[i][j] = " ";
            }
        }

        int shapeInput;
        int temp = -1;
        Scanner userInput = new Scanner(System.in);
        Shapes shape = new Shapes();

        // Getting shapes from the user until they want to quit
        while (temp != 0){
            System.out.println("How many shapes would you like to have?");
            shapeInput = userInput.nextInt();
            int shapeArr[] = new int[shapeInput];

            // If user gives n numbers of shapes that is NOT 0
            if(shapeInput != 0){
                // Getting the type of shape the user wants
                for(int i=0; i<shapeInput; i++){
                    System.out.println("Enter 1 for Circle, 2 for Rectangle, 3 for Triangle, 0 to stop");
                    shapeArr[i] = userInput.nextInt();
                    // If the user wants to stop
                    if(shapeArr[i] == 0){
                        temp = 0;
                    }
                }
                shape.displayShapes(shapeArr, shapeInput, userInput);
            } else{
                temp = 0;
            }
        }
    }
}
