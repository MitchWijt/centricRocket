public class SpaceShip {
    private final String name;
    private int health;
    private int fuel;
    private final Navigation navigation;

    public SpaceShip(String name) {
        this.name = name;
        this.health = 100;
        this.fuel = 100;
        this.navigation = new Navigation();
    }

    public String getName() {
        return this.name;
    }

    public Navigation getNavigation() {
        return this.navigation;
    }

    public int getFuel() {
        return this.fuel;
    }

    public int getHealth() {
        return this.health;
    }

    public void getShipStats() {
        System.out.printf("Ship health: %d\nShip fuel: %d\n", this.health, this.fuel);
    }

    public void refillHealth() {
        this.health = 100;
    }

    public void addFuel(int fuel) {
        this.fuel += fuel;
    }

    public void flyToPlanet(Planet planet) {
        int fuelCost = planet.getDistanceFromEarth() / 10;
        this.fuel -= fuelCost;

        this.navigation.updateTravelLog("Flown to " + planet.getName() + "\n");
        System.out.printf("Flying to planet %s\n", planet.getName());
    }
}
