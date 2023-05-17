package diskscheduling_group1;

//import java.util.*;

public class Fcfs {

    public static int fcfs(int current_position, int track_size, int[] requests, int total_head_movement, int seek_time) {
        // Compute total seek time using FCFS algorithm
        int head_movement = total_head_movement;

        for (int i = 0; i < requests.length; i++) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
            head_movement += seek_time;
        }

        return head_movement;
    }
}
