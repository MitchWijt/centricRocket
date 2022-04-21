public class Planet {
    private final String name;
    private final int distanceFromEarth;
    private final boolean canRepairShip;
    private final int availableFuel;

    public Planet(String name, int distanceFromEarth, boolean canRepairShip, int availableFuel) {
        this.name = name;
        this.distanceFromEarth = distanceFromEarth;
        this.canRepairShip = canRepairShip;
        this.availableFuel = availableFuel;
    }

    public String getName() {
        return this.name;
    }

    public int getDistanceFromEarth() {
        return this.distanceFromEarth;
    }

    public boolean getCanRepairShip() {
        return this.canRepairShip;
    }

    public int getAvailableFuel() {
        return this.availableFuel;
    }

    public void repairShip(SpaceShip spaceShip) {
        if(!this.canRepairShip) {
            System.out.println("Ship cannot be repaired on this planet");
            return;
        }

        spaceShip.refillHealth();
        System.out.println("Ship has been repaired");
    }

    public void refillShip(SpaceShip spaceShip) {
        if(this.availableFuel <= 0) {
            System.out.println("Gas station is out of fuel");
            return;
        }
        spaceShip.refuel(this.availableFuel);
    }
}
