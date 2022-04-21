public class Planet {
    private final String name;
    private final int distanceFromEarth;
    private final boolean canRepairShip;
    private int availableFuel;

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

    public void refillSpaceship(SpaceShip spaceShip) {
        int fuelToTank = 100 - spaceShip.getFuel();

        if(this.availableFuel - fuelToTank < 0) {
            System.out.println("Gas cannot be filled here");
            return;
        }

        this.availableFuel -= fuelToTank;
        spaceShip.addFuel(fuelToTank);
    }

//    public void repairShip(SpaceShip spaceShip) {
//        if(!this.canRepairShip) {
//            System.out.println("Ship cannot be repaired on this planet");
//            return;
//        }
//
//        spaceShip.refillHealth();
//        System.out.println("Ship has been repaired");
//    }
}
