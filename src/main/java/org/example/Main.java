package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "names.txt"; // Replace with the actual file path

        try {
            Map<Person, Integer> personCount = new HashMap<>();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    Person person = new Person(parts[0], parts[1]);
                    personCount.put(person, personCount.getOrDefault(person, 0) + 1);
                }
            }

            reader.close();

            // Display persons with at least 3 occurrences
            for (Map.Entry<Person, Integer> entry : personCount.entrySet()) {
                if (entry.getValue() >= 3) {
                    System.out.println(entry.getKey().getFullName() + " appears " + entry.getValue() + " times");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}