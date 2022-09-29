package students;

import java.util.Random;

public class StudentGenerator {

    private static final String[] firstName = {
            "Jack",
            "James",
            "April",
            "Mary",
            "Andrew",
            "Sarah",
            "Shane",
            "Dylan",
            "Michael",
            "Aaron",
            "Steven",
            "Alan",
            "Peter",
            "Laura"
    };

    private static final String[] lastName = {
            "Foley",
            "Doyle",
            "Cullen",
            "O Brien",
            "Murphy",
            "Paul",
            "Jordan",
            "Roche",
            "Kelly",
            "Moreau"
    };

    public static Student generate() {
        Random random = new Random();
        String name = firstName[random.nextInt(firstName.length)] + " " + lastName[random.nextInt(lastName.length)];
        String address = random.nextInt(100) + " " + lastName[random.nextInt(lastName.length)] + " Street";
        int age = random.nextInt(20) + 18;
        // student id: min 200000, max 999999
        String id = String.valueOf(random.nextInt(800000) + 200000);
        return new Student("C00" + id, name, address, age);
    }

}
