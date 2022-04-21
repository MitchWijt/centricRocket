public class SpaceShip {
    private final String name;
    protected int health;
    protected int fuel;
    private int distanceTravelled;

    public SpaceShip(String name) {
        this.name = name;
        this.health = 100;
        this.fuel = 100;
        this.distanceTravelled = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public void updateDistanceTravelled(int distance) {
        this.distanceTravelled += distance;
    }

    public void refillHealth() {
        this.health = 100;
    }

    public void refuel(int fuel) {
        this.fuel += fuel;
    }

    public int getRemainingFuel() {
        return this.fuel;
    }

    public void flyToPlanet(Planet planet) {
        System.out.println("Flying to a new planet");
    }
}
