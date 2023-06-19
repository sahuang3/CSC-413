public class Rectangle {

    int temp1;
    int temp2;

    public Rectangle(){
        temp1 = 0;
        temp2 = 0;
    }

    public void displayFill(int height, int size){

        for(int i=0; i<height; i++){
            temp2 = 0;
            System.out.print("*");
            Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
            for(int j=0; j<size; j++){
                System.out.print("*");
                Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
            }
            System.out.println();
            temp1++;
        }
    }

    public void displayNoFill(int height, int size){

        for(int i=0; i<height; i++){
            temp2 = 0;
            for(int j=0; j<size; j++){
                // Top row
                if(i==0){
                    System.out.print("*");
                    Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
                } else if(i==height-1){
                    // Bottom row
                    System.out.print("*");
                    Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
                } else if( j==0 || j==size-1){
                    // First and Last index of each row (the sides)
                    System.out.print("*");
                    Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
                } else{
                    // Hollow middle
                    System.out.print(" ");
                    temp2++;
                }
            }
            temp1++;
            System.out.println();
        }
    }
}
