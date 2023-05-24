package diskscheduling_group1;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
*/

public class Look {
    
    public static int main(int current_position, int track_size, int[] requests)
    {
        /*
        BufferedReader bfn = new BufferedReader(
        new InputStreamReader(System.in));

        System.out.println("Input current position: ");
        int start = Integer.parseInt(bfn.readLine()); //starting position
        
        System.out.println("Input track size: ");
        int size = Integer.parseInt(bfn.readLine()); //numbering is from 0 to size-1
        
        int n = -1;
        do
        {
            System.out.println("Input Number of Requests (10 max): ");
            n = Integer.parseInt(bfn.readLine());
        }
        while (n < 0 || n > 10); // This will repeat if inputted number is wrong
        
        
        //locations
        int loc[][] = new int[n][2];

        int countGreater = 0; //count for how many locations are greater than start
        int countLess = 0; //count for how many locations are less than start
        
        System.out.println("Input the locations of the requests: ");
        for (int i = 1; i <= n; i++)
        {
            loc[i-1][0] = i; //queue number;
            
            do
            {
            System.out.print("Loc " + i + ": ");
            loc[i-1][1] = Integer.parseInt(bfn.readLine());
            System.out.println("");
            }
            while (loc[i-1][1] < 0 || loc[i-1][1] > size-1);
                
            if (loc[i-1][1] > start)
            {
                countGreater = countGreater + 1;
            }
            else if (loc[i-1][1] < start)
            {
                countLess = countLess + 1;
            }
            else
            {
                
            }
        }

        */

        int start = current_position;
        int size = track_size;
        int n = requests.length;
        int loc[][] = new int[n][2];
        int countGreater = 0; //count for how many locations are greater than start
        int countLess = 0; //count for how many locations are less than start
        
        for (int i = 1; i <= n; i++)
        {
            loc[i-1][0] = i;
            loc[i-1][1] = requests[i-1];
            
            if (loc[i-1][1] > start)
            {
                countGreater = countGreater + 1;
            }
            else if (loc[i-1][1] < start)
            {
                countLess = countLess + 1;
            }
            else
            {
                
            }
        }

        
        //sort
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++) 
            {
                int tempA = 0;
                int tempB = 0;
                
                if (loc[j][1] < loc[i][1]) 
                {
                    tempA = loc[i][0];
                    tempB = loc[i][1];
                    
                    loc[i][0] = loc[j][0];
                    loc[i][1] = loc[j][1];
                    
                    loc[j][0] = tempA;
                    loc[j][1] = tempB;
                }
            }
        }
        
        
        int greaterThanStart [][] = new int [countGreater][2];
        int lessThanStart [][] = new int [countLess][2];
        
        int greaterIndex = 0;
        int lessIndex = 0;
        
        for (int i = 0; i < n; i++)
        {
            if (loc[i][1] > start)
            {
                greaterThanStart [greaterIndex][0] = loc[i][0];
                greaterThanStart [greaterIndex][1] = loc[i][1];
                greaterIndex = greaterIndex + 1;
            }
            else if (loc[i][1] < start)
            {
                lessThanStart [lessIndex][0] = loc[i][0];
                lessThanStart [lessIndex][1] = loc[i][1];
                lessIndex = lessIndex + 1;
            }
            else
            {
                
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
            thm = start - lessThanStart [0][1]; //total head movement from start to lowest number;
            thm = thm + greaterThanStart [countGreater - 1][1] - lessThanStart [0][1]; //add to total head movement from lowest number to highest number;
        }
        else 
        {
            thm = greaterThanStart [countGreater -1][1] - start; //total head movement from start to highest number;
            thm = thm + greaterThanStart [countGreater - 1][1] - lessThanStart [0][1]; //add to total head movement from highest number to lowest number;
        }
        
        /*
        System.out.println("");
        System.out.println("Total head movement: " + thm);
        System.out.println("");
        */
        
        return thm;
    }
    
}
