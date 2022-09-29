package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import students.StudentManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cabinet {

    private final Gson gson;

    public Cabinet() {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        gson = builder.create();

        if (createFile("src/files", "students.json")) System.out.println("Created students.json");
        if (createFile("src/files", "halls.json")) System.out.println("Created halls.json");
    }

    public boolean createFile(String path, String fileName) {
        boolean success = false;
        File file = new File(path, fileName);
        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    public String convertHallsToJson(Building building) {
        Map<String, List<Hall>> buildingHallMap = new HashMap<>();
        buildingHallMap.put(building.getBuildingName(), building.getHalls());
        return gson.toJson(buildingHallMap);
    }

    public String convertStudentsToJson(StudentManager manager) {
        return gson.toJson(manager.students);
    }

    public boolean write(String path, String fileName, String text) {

        boolean success = false;
        File file = new File(path, fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(text);
            writer.close();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return success;

    }

}
