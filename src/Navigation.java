import java.util.ArrayList;

public class Navigation {
    private ArrayList<String> travelLog;

    public Navigation() {
        this.travelLog = new ArrayList<>();
    }


    public void getTravelLog() {
        for(String log : travelLog) {
            System.out.println(log);
        }
    }

    public void updateTravelLog(String route) {
        this.travelLog.add(route);
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
