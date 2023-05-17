package diskscheduling_group1;

//import java.util.*;

public class Sstf {

    public static int sstf(int current_position, int track_size, int[] requests) {
        // Compute total seek time using SSTF algorithm
        int head_movement = 0;
        boolean[] visited = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int shortestDistance = Integer.MAX_VALUE;
            int shortestIndex = -1;

            for (int j = 0; j < requests.length; j++) {
                if (!visited[j]) {
                    int distance = Math.abs(requests[j] - current_position);
                    if (distance < shortestDistance) {
                        shortestDistance = distance;
                        shortestIndex = j;
                    }
                }
            }

            head_movement += shortestDistance;
            current_position = requests[shortestIndex];
            visited[shortestIndex] = true;
        }

        return head_movement;
    }
}