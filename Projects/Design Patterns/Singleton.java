public class Singleton {
    private static Singleton INSTANCE = null;

    private Singleton(){
        //
    }

    public static Singleton getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singleton();
            System.out.println("CREATING OBJECT");
        }
        return INSTANCE;
    }

    public void printMessage(){
        System.out.println("Hello World!");
    }
}
