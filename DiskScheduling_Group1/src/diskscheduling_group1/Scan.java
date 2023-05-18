package diskscheduling_group1;

import java.util.*;

public class Scan {

    public static int scan(int current_position, int track_size, int[] requests) {
        int head_movement = 0;

        // Sort the requests in ascending order
        Arrays.sort(requests);

        // Find the index where the current position would be inserted
        int index = Arrays.binarySearch(requests, current_position);

        // Adjust the index if the current position is not found
        if (index < 0) {
            index = -(index - 1);
        }

        // Move the head towards the right track
        for (int i = index; i < requests.length; i++) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
        }

        // Handle the case when the head is at the rightmost track
        if (current_position != track_size - 1) {
            head_movement += Math.abs(track_size - 1 - current_position); // Move to the rightmost track
            current_position = track_size - 1;
        }

        // Move the head towards the left track
        for (int i = index - 1; i >= 0; i--) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
        }

        return head_movement;
    }
}