public class Rocket extends SpaceShip {
    public Rocket(String name) {
        super(name);
    }

    public int getRemainingFuel() {
        return this.fuel;
    }

    public void flyToPlanet(Planet planet) {
        System.out.println("Flying to a new planet");
    }
}
