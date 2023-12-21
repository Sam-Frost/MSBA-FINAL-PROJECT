package org.ncu.project.auxilary;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class RoomGenerator {

    public String generateVacantRooms(int numOfRooms) {
        Set<Integer> roomSet = new HashSet<>();
        Random random = new Random();

        // Generate unique random room numbers
        while (roomSet.size() < numOfRooms) {
            int roomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
            roomSet.add(roomNumber);
        }

        // Convert the set of room numbers to a formatted string
        String roomNumbers = roomSet.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        // Print the generated room numbers
        System.out.println("Generated Vacant Room Numbers: " + roomNumbers);

        // Return the formatted string of room numbers
        return roomNumbers;
    }
}
