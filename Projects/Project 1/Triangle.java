public class Triangle {

    public int temp1;
    public int temp2;

    public Triangle(){
        temp1 = 0;
        temp2 = 0;
    }

    public void displayFill(int height){

        for(int i=0; i<=height; i++){
            temp2 = 0;
            // The empty spaces
            for(int j=height; j>=i; j--){
                System.out.print(" ");
                temp2++;
            }

            // The left side of the triangle, including the center column
            for(int j=1; j<=i; j++){
                System.out.print("*");
                Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
            }

            // The right side of the triangle, excluding the center column
            for(int j=1; j<i; j++){
                System.out.print("*");
                Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
            }
            temp1++;
            System.out.println();
        }

    }

    public void displayNoFill(int height){

        for(int i=1; i<=height; i++){
            temp2 = 0;
            // Empty spaces for triangle spacing
            for(int j=1; j<=height-i; j++){
                System.out.print(" ");
                temp2++;
            }
            // Actual triangle
            for(int j=1; j<=2*i-1; j++){
                // Edges of the triangle
                if(j==1 || j==2*i-1 || i==height){
                    System.out.print("*");
                    Main.display[Main.yPos+temp1][Main.xPos+temp2++] = "*";
                } else{
                    // Hollow middle
                    System.out.print(" ");
                    temp2++;
                }
            }
            System.out.println();
            temp1++;

        }

    }

}
