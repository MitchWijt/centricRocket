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
        this.spaceShip.getNavigation().getTravelLog();
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
        System.out.println("Please pick a name for your spaceShip");
        String name = getUserInput();

        this.spaceShip = new SpaceShip(name);
        System.out.printf("You have chosen to fly with the %s\n", this.spaceShip.getName());
        wait(2000);
    }

    public void startGameLoop() {
        System.out.println("Welcome to centricRocket!");
        startGame();
        // game exists automatically when rocket fuel is 0 or when rocket health is 0

        while(gameIsRunning) {
            System.out.println("What destination do you want to fly to?");
            this.spaceShip.getNavigation().printAvailableDestinations(this.planets);

            String chosenPlanetOption = getUserInput();
            Planet chosenPlanet = this.planets.get(Integer.parseInt(chosenPlanetOption));
            this.spaceShip.flyToPlanet(chosenPlanet);

            System.out.println("Pshhhhhhh.....");
            wait(5000);

            this.spaceShip.getShipStats();
            wait(2000);

            System.out.println("Would you like to refill your spaceship? y/n");
            String chosenInputGas = getUserInput();
            if(chosenInputGas.equals("y")) {
                chosenPlanet.refillSpaceship(this.spaceShip);
            }

            if(this.spaceShip.getFuel() <= 0 || this.spaceShip.getHealth() <= 0) {
                System.out.println("Beep Boop Beep Boop");
                wait(2000);
                System.out.println("Your ship is not able to fly anymore");
                wait(2000);
                stopGame();
            }

            System.out.println("Do you want to fly again? y/n");
            String chosenInput = getUserInput();
            if(chosenInput.equals("n")) {
                stopGame();
            }
        }
    }

    public String getUserInput() {
        String value = "";

        while(value.equals("")) {
            Scanner input = new Scanner(System.in);
            value =  input.nextLine();
            if(value.equals("")) System.out.println("Invalid Value");
        }

        if(value.equals("exit")) stopGame();
        return value;
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
