package diskscheduling_group1;

//import java.util.*;
public class Fcfs {

    public static int fcfs(int current_position, int track_size, int[] requests) {
        int head_movement = 0;

        for (int i = 0; i < requests.length; i++) {
            head_movement += Math.abs(requests[i] - current_position);
            current_position = requests[i];
        }

        return head_movement;
    }
}
