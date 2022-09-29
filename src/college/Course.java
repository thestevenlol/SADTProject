package college;

import java.util.List;

public class Course {

    private String courseCode, courseTitle;
    private int moduleAmount, maxStudents;
    private List<Module> modules;

    public Course(String courseCode, String courseTitle, int moduleAmount, int maxStudents, List<Module> modules) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.moduleAmount = moduleAmount;
        this.maxStudents = maxStudents;
        this.modules = modules;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getModuleAmount() {
        return moduleAmount;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public List<Module> getModules() {
        return modules;
    }
}
