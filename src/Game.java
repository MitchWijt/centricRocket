import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Game {
    private ArrayList<Planet> planets;
    private SpaceShip spaceShip;
    private boolean gameIsRunning = true;

    public Game() {
        this.planets = new ArrayList<>();
    }

    public void startGame() {
        createPlanets();
        createSpaceship();

        this.gameIsRunning = true;
        System.out.println("Welcome to centricRocket!");
    }

    public void stopGame() {
        this.gameIsRunning = false;
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
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/config/spaceship.json"));
            this.spaceShip = gson.fromJson(reader, SpaceShip.class);

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void startGameLoop() {
        startGame();

        // We need to choose to fly to a certain planet with user input.
        // after every choice we need to display the spaceShip stats
        // game exists automatically when rocket fuel is 0 or when rocket health is 0

        while(gameIsRunning) {
            System.out.println("Game is running");
        }

        System.out.println("Game has stopped. Here is your fly log!");
    }
}
