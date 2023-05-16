package diskscheduling_group1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLook {
    
    public static void main(String[] args) throws IOException 
    {
        
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


        //processes
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
        
        //separate into 2 arrays: one greater than start and the other less than start
        for (int i = 0; i < n; i++)
        {
            if (loc[i][1] > start)
            {
                greaterThanStart [greaterIndex][0] = loc[i][0];
                greaterThanStart [greaterIndex][1] = loc[i][1];
                greaterIndex = greaterIndex + 1;
            }
            else if (loc[i-1][1] < start)
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
        
        //depends on queue number
        if (lessThanStart [countLess - 1][0] < greaterThanStart [0][0])
        {
            thm = start - lessThanStart [0][1]; //total head movement from start to lowest
            thm = thm + greaterThanStart [countGreater][1] - lessThanStart [0][1]; //total head movement from lowest to highest
            thm = thm + greaterThanStart [countGreater][1] - greaterThanStart [0][1]; //total head movement from highest to lowest greaterThanStart
        }
        else 
        {
            thm = greaterThanStart [countGreater][1] - start; //total head movement from start to highest
            thm = thm + greaterThanStart [countGreater][1] - lessThanStart [0][1]; //total head movement from highest to lowest
            thm = thm + lessThanStart [countLess][1] - lessThanStart [0][1]; //total head movement from lowest to highest lessThanStart
        }
        
        System.out.println("");
        System.out.println("Total head movement: " + thm);
        System.out.println("");
        
    }
}
