import java.util.ArrayList;

public class Navigation {
    private int distanceTravelled;
    private ArrayList<String> travelLog;

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public ArrayList<String> getTravelLog() {
        return this.travelLog;
    }

    public void updateTravelLog(String route) {
        this.travelLog.add(route);
    }

    public void updateDistanceTravelled(int distance) {
        this.distanceTravelled += distance;
    }

    public void printAvailableDestinations(ArrayList<Planet> planets) {
        for(int i = 0; i < planets.size(); i++){
            Planet planet = planets.get(i);
            System.out.printf("%d. Planet name: %s\nDistance from earth: %d\nCan repair ship: %b\nAvailable Fuel: %d\n\n",
                    i,
                    planet.getName(),
                    planet.getDistanceFromEarth(),
                    planet.getCanRepairShip(),
                    planet.getAvailableFuel()
            );
        }
    }

}
