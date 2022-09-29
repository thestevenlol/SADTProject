package util;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private String buildingName;
    private int floors;
    private int totalHalls;
    private List<Hall> halls;
    private String buildingPrefix;

    private final Cabinet cabinet = new Cabinet();

    public Building() {
        // Haughton building
        List<Hall> haughtonHalls = new ArrayList<>();
        Building haughton = new Building("L", "Haughton", 2, 3, haughtonHalls);
        haughtonHalls.add(new Hall(114, 100, 0));
        haughtonHalls.add(new Hall(115, 100, 0));
        haughtonHalls.add(new Hall(117, 200, 0));
        haughton.writeToFile();
    }

    public Building(String buildingPrefix, String buildingName, int floors, int totalHalls, List<Hall> halls) {
        this.buildingName = buildingName;
        this.floors = floors;
        this.totalHalls = totalHalls;
        this.halls = halls;
        this.buildingPrefix = buildingPrefix;
    }

    public void writeToFile() {
        String json = cabinet.convertHallsToJson(this);
        cabinet.write("src/files", "halls.json", json);
    }

    public String getBuildingPrefix() {
        return buildingPrefix;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public int getFloors() {
        return floors;
    }

    public int getTotalHalls() {
        return totalHalls;
    }

    public List<Hall> getHalls() {
        return halls;
    }
}
