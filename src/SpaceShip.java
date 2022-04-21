public abstract class SpaceShip {
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

    public void refillHealth() {
        this.health = 100;
    }

    public void refuel(int fuel) {
        this.fuel += fuel;
    }

    public abstract int getRemainingFuel();
    public abstract void flyToPlanet(Planet planet);
}
