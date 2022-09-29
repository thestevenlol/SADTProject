package students;

import util.Cabinet;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    Cabinet cabinet = new Cabinet();
    public List<Student> students = new ArrayList<>();

    public StudentManager() {
        for (int i = 0; i < 1200; i++) {
            students.add(StudentGenerator.generate());
        }
        writeToFile();
    }

    private void writeToFile() {
        cabinet.write("src/files", "students.json", cabinet.convertStudentsToJson(this));
    }

}
