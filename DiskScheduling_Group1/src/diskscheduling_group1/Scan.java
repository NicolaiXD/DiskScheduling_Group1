package diskscheduling_group1;

import java.util.*;

public class Scan {

    public static int scan(int current_position, int track_size, int[] requests) {
        // Compute total seek time using SCAN algorithm
        int head_movement = 0;

        // Sort the requests in ascending order
        Arrays.sort(requests);

        int currentIndex = Arrays.binarySearch(requests, current_position);
        if (currentIndex < 0) {
            currentIndex = -(currentIndex + 1);
        }

        // Calculate head movement towards higher track numbers
        for (int i = currentIndex; i < requests.length; i++) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
        }

        // Calculate head movement towards lower track numbers
        head_movement += Math.abs(track_size - 1 - current_position);

        for (int i = currentIndex - 1; i >= 0; i--) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
        }

        return head_movement;
    }
}
