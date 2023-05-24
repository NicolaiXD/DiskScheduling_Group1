package diskscheduling_group1;

//import java.util.*;
public class Scan {

    public static int scan(int current_position, int track_size, int[] requests) {
        int start = current_position;
        int size = track_size;
        int n = requests.length;
        int loc[][] = new int[n][2];
        int countGreater = 0; //count for how many locations are greater than start
        int countLess = 0; //count for how many locations are less than start

        for (int i = 1; i <= n; i++) {
            loc[i - 1][0] = i;
            loc[i - 1][1] = requests[i - 1];

            if (loc[i - 1][1] > start) {
                countGreater = countGreater + 1;
            } else if (loc[i - 1][1] < start) {
                countLess = countLess + 1;
            } else {

            }
        }

        //sort
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tempA = 0;
                int tempB = 0;

                if (loc[j][1] < loc[i][1]) {
                    tempA = loc[i][0];
                    tempB = loc[i][1];

                    loc[i][0] = loc[j][0];
                    loc[i][1] = loc[j][1];

                    loc[j][0] = tempA;
                    loc[j][1] = tempB;
                }
            }
        }

        int greaterThanStart[][] = new int[countGreater][2];
        int lessThanStart[][] = new int[countLess][2];

        int greaterIndex = 0;
        int lessIndex = 0;

        for (int i = 0; i < n; i++) {
            if (loc[i][1] > start) {
                greaterThanStart[greaterIndex][0] = loc[i][0];
                greaterThanStart[greaterIndex][1] = loc[i][1];
                greaterIndex = greaterIndex + 1;
            } else if (loc[i][1] < start) {
                lessThanStart[lessIndex][0] = loc[i][0];
                lessThanStart[lessIndex][1] = loc[i][1];
                lessIndex = lessIndex + 1;
            } else {

            }
        }

        int thm = 0; //total head movement

        
        if (countLess <= 0) // if no value is less than start
        {
            thm = greaterThanStart [countGreater - 1][1] - start; //total head movement from start to highest number;
        }
        else if (countGreater <= 0) // if no value is greater than start
        {
            thm = start - lessThanStart [0][1]; //total head movement from start to lowest number;
        }
        //depends on queue number
        else if (lessThanStart [countLess - 1][0] < greaterThanStart [0][0])
        {
            thm = start + greaterThanStart [countGreater - 1][1]; //total head movement from start to 0 to highest number;
        }
        else 
        {
            thm = size - 1 - start + size -1 - lessThanStart [0][1]; //total head movement from start to maxlimit to lowest number;
        }

        return thm;
    }
}
