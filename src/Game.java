import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Game {
    private final ArrayList<Planet> planets;
    private SpaceShip spaceShip;
    private boolean gameIsRunning = true;

    public Game() {
        this.planets = new ArrayList<>();
    }

    public void startGame() {
        createPlanets();
        createSpaceship();
        this.gameIsRunning = true;
    }

    public void stopGame() {
        System.out.println("Game has stopped. Here is your fly log!");
        this.gameIsRunning = false;
        System.exit(1);
    }

    public void createPlanets() {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/config/planets.json"));
            Planet[] parsedPlanets = gson.fromJson(reader, Planet[].class);

            this.planets.addAll(Arrays.asList(parsedPlanets));

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void createSpaceship() {
        String name = "";

        while(name.equals("")) {
            System.out.println("Please pick a name for your spaceShip");

            Scanner input = new Scanner(System.in);
            name = input.nextLine();

            if(name.equals("")) {
                System.out.println("Invalid name");
            }
        }

        this.spaceShip = new SpaceShip(name);
        System.out.printf("You have chosen to fly with the %s\n", this.spaceShip.getName());
        wait(2000);
    }

    public void startGameLoop() {
        System.out.println("Welcome to centricRocket!");
        startGame();
        // We need to choose to fly to a certain planet with user input.
        // after every choice we need to display the spaceShip stats
        // game exists automatically when rocket fuel is 0 or when rocket health is 0

        while(gameIsRunning) {
            System.out.println("What destination do you want to fly to?");
            this.spaceShip.getNavigation().printAvailableDestinations(this.planets);

            Scanner planetOptionInput = new Scanner(System.in);
            int chosenOption = planetOptionInput.nextInt();

            Planet chosenPlanet = this.planets.get(chosenOption);
            this.spaceShip.flyToPlanet(chosenPlanet);

            System.out.println("Pshhhhhhh.....");
            wait(5000);

            this.spaceShip.getShipStats();
            wait(2000);

            System.out.println("Do you want to fly again? y/n");
            Scanner continueFlyingInput = new Scanner(System.in);
            String stringInput = continueFlyingInput.nextLine();
            if(stringInput.equals("n")) {
                stopGame();
            }
        }
    }

    public static void wait(int ms) {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}
