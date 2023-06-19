// TODO: Exercise 1 - Singleton
// TODO: Exercise 2 - Decorator

import java.util.Scanner;

public class Lecture6 {
    public static void main(String[] args) {
        System.out.println("Welcome to Adventures of CSC!\n\n");

        mainMenu();
    }

    public static void mainMenu() {
        // Display menu options
        System.out.println("""
        Choose an option:
        1) New Game
        2) Exit
        """);

        // Get an integer option from the user
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        // Decide what to do
        switch (choice) {
            case 1:
                newGameMenu();
                break;
            case 2:
                System.out.println("Thanks for playing!");
                return;
        }

        // Repeat menu options until a valid choice is entered
        mainMenu();
    }

    public static void newGameMenu() {
        System.out.println("You enter a vast realm of computational adventure!");

        World world = World.getInstance();

        // Run game loop
        world.runGame("start");
    }
}
