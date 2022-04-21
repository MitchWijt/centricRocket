public class SpaceShip {
    private final String name;
    protected int health;
    protected int fuel;
    private Navigation navigation;

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

    public void getShipStats() {
        System.out.printf("Ship health: %d\nShip fuel: %d\n", this.health, this.fuel);
    }

    public int getRemainingFuel() {
        return this.fuel;
    }

    public void refillHealth() {
        this.health = 100;
    }

    public void refuel(int fuel) {
        this.fuel += fuel;
    }

    public void reduceFuel(int fuelCost) {
        this.fuel -= fuelCost;
    }

    public void flyToPlanet(Planet planet) {
        int fuelCost = planet.getDistanceFromEarth() * 2;
        reduceFuel(fuelCost);
        System.out.printf("Flying to planet %s\n", planet.getName());
    }
}
