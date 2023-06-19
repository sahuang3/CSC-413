public class Circle {

    public int temp1;
    public int temp2;

    public Circle(){
        temp1 = 0;
        temp2 = 0;
    }

    public void displayFill(int radius){

        for(int i=0; i<=radius; i++){
            temp1 = 0;

            // If it's within the range, there will be a "*", otherwise a "space"
            for(int j=0; j<=radius; j++){
                double tempDistance = (radius/2 -i) * (radius/2 -i) + (radius/2 -j) * (radius/2 -j);
                if(tempDistance<=((radius/2)*(radius/2)+1)){
                    System.out.print("*");
                    Main.display[Main.yPos+temp2][Main.xPos+ temp1++] = "*";
                } else{
                    System.out.print(" ");
                    temp1++;
                }
            }
            System.out.println();
            temp2++;
        }

    }

    public void displayNoFill(int radius) {

        for (int i=0; i<=radius; i++) {
            temp2 = 0;

            // If it's within the range of the borders, "*", otherwise "space"
            for (int j=0; j<=radius; j++) {
                double tempDistance = Math.sqrt((i-radius/2) * (i-radius/2) + (j-radius/2) * (j-radius/2));
                if(tempDistance > (radius/2)-0.5 && tempDistance < (radius/2)+0.5){
                    System.out.print("*");
                    Main.display[Main.yPos+temp1][Main.xPos+ temp2++] = "*";
                } else{
                    System.out.print(" ");
                    Main.display[Main.yPos+temp1][Main.xPos+ temp2++] = " ";
                    temp2++;
                }
            }
            System.out.println();
            temp1++;
        }
    }
}
