import java.util.*;

public class Shapes {

    private int size;
    private int height;


    // Default constructor
    public Shapes(){
        size = 0;
        height = 0;
    }

    // Getter/Setters Functions
    public int getSize(){
        return size;
    }

    public int getHeight(){
        return height;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setHeight(int height){
        this.height = height;
    }


    // TODO: Minimum Must-have functions:
    // menu - to show menu interface and ask user for specifications and coordinates
    // fill - initialize shape objects and asks the user if they want to fill it or not
    // display - to display the output of the shapes in X-Y coordinates


    // Getting the specifications of the shapes through a Menu interface
    public void userMenu(int userShape, Scanner userInput){

        // If userShape = 1, then it's a Circle
        // If userShape = 2, then it's a Rectangle
        // If userShape = 3, then it's a Triangle
        if(userShape == 1){

            // Getting radius from the user
            System.out.println("What radius do you want your Circle to be?");
            setSize(userInput.nextInt());

            // Getting coordinates from the user
            System.out.println("Enter X and Y coordinates for the shape to be placed");
            Main.xPos = userInput.nextInt();
            Main.yPos = userInput.nextInt();

            // Check if the user wants to fill in their shape
            fillCheck(userShape, userInput);

        } else if(userShape == 2) {

            // Getting height and width from the user
            System.out.println("What height do you want your Rectangle to be?");
            setHeight(userInput.nextInt());
            System.out.println("What width do you want your Rectangle to be?");
            setSize(userInput.nextInt());

            // Getting coordinates from the user
            System.out.println("Enter X and Y coordinates for the shape to be placed");
            Main.xPos = userInput.nextInt();
            Main.yPos = userInput.nextInt();

            // Check if the user wants to fill in their shape
            fillCheck(userShape, userInput);

        } else if(userShape == 3) {

            // Getting height from the user
            System.out.println("What height do you want your Triangle to be?");
            setHeight(userInput.nextInt());

            // Getting coordinates from the user
            System.out.println("Enter X and Y coordinates for the shape to be placed");
            Main.xPos = userInput.nextInt();
            Main.yPos = userInput.nextInt();

            // Check if the user wants to fill in their shape
            fillCheck(userShape, userInput);

        }
    }

    // Asks user if they want the shapes to be filled
    public void fillCheck(int userShape, Scanner userInput){

        Circle circle1 = new Circle();
        Rectangle rectangle1 = new Rectangle();
        Triangle triangle1 = new Triangle();

        // Asking the user if they want the shapes to be filled
        System.out.println("Do you want your shapes to be filled? Enter Yes or No");
        String userOutline = userInput.next();

        // If user wants the shapes to be filled
        if(userOutline.equalsIgnoreCase("yes")){
            if(userShape == 1){
                circle1.displayFill(getSize());
            } else if(userShape == 2) {
                rectangle1.displayFill(getHeight(), getSize());
            } else if(userShape == 3) {
                triangle1.displayFill(getHeight());
            }
        } else{
            // If user doesn't want the shapes to be filled
            if(userShape == 1){
                circle1.displayNoFill(getSize());
            }else if(userShape == 2) {
                rectangle1.displayNoFill(getHeight(), getSize());
            } else if(userShape == 3) {
                triangle1.displayNoFill(getHeight());
            }
        }
    }

    public void displayShapes(int[] userShape, int shapeInput, Scanner userInput){

        // Displaying the shape you're getting
        for(int i=0; i<shapeInput; i++){
            userMenu(userShape[i], userInput);
        }
        System.out.println();
        System.out.println("Output:");
        System.out.println();


        // Printing out the shapes stored in the 2D array with coordinates
        for(int i=0; i<Main.display.length; i++){
            for(int j=0; j<Main.display.length; j++){
                System.out.print(Main.display[i][j]);
            }
            System.out.println();
        }
    }

}
