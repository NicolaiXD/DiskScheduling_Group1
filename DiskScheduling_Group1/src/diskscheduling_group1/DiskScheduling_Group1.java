package diskscheduling_group1;

/**
 * Jaden Ezriel Go and Lenar Guzman 26012 - Operating Systems Part 2
 */
import static diskscheduling_group1.Fcfs.fcfs;
import static diskscheduling_group1.Scan.scan;
import static diskscheduling_group1.Sstf.sstf;

import java.io.IOException;
import java.util.Scanner;

public class DiskScheduling_Group1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Let user choose which Disk Scheduling:");
        System.out.println("[A] First Come First Serve (FCFS)");
        System.out.println("[B] Shortest Seek Time First (SSTF)");
        System.out.println("[C] Scan");
        System.out.println("[D] Look");
        System.out.println("[E] Circular Scan (CSCAN)");
        System.out.println("[F] Circular Look (CLOOK)");
        System.out.println("[G] Exit");

        System.out.print("Enter your choice: ");
        String choice = scanner.next();

        int head_movement = 0;

        

        int current_position, track_size, num_requests;
        int[] requests;

        do {
            System.out.print("Input Current Position: ");
            current_position = scanner.nextInt();

            System.out.print("Input Track Size: ");
            track_size = scanner.nextInt();

            do
            {
                System.out.print("Input number of requests (1 to 10): ");
                num_requests = scanner.nextInt();

            }
            while (num_requests < 1 || num_requests > 10); // This will repeat if inputted number is wrong
            
            
            System.out.println("Input the requests:");
            requests = new int[num_requests];
            
            for (int i = 0; i < num_requests; i++) {

                do
                {
                System.out.print("Loc " + i + ": ");
                requests[i] = scanner.nextInt();
                System.out.println("");
                }
                while (requests[i] < 0 || requests[i] > track_size-1);
            }

            
            
            switch (choice.toUpperCase()) {
                case "A":
                    head_movement = fcfs(current_position, track_size, requests);
                    break;
                case "B":
                    head_movement = sstf(current_position, track_size, requests);
                    break;
                case "C":
                    head_movement = scan(current_position, track_size, requests);
                    break;
                case "D":
                    head_movement = Look.main(current_position, track_size, requests);
                    /*
                    try {
                    Look.main(new String[0]);
                } catch (IOException e) {
                    System.out.println("An error occurred while executing Look: " + e.getMessage());
                }*/
                break;
                case "E":
                    head_movement = CLook.main(current_position, track_size, requests);
                    /*
                    try {
                    CLook.main(new String[0]);
                } catch (IOException e) {
                    System.out.println("An error occurred while executing CLook: " + e.getMessage());
                }*/
                case "F":
                    head_movement = CScan.main(current_position, track_size, requests);
                    /*
                    try {
                    CScan.main(new String[0]);
                } catch (IOException e) {
                    System.out.println("An error occurred while executing CScan: " + e.getMessage());
                }*/
                    break;
                case "G":
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            System.out.println("Total head movement: " + head_movement);

            System.out.print("Input again (y/n)? ");
            String repeat = scanner.next();

            if (!repeat.equalsIgnoreCase("y")) {
                System.out.println("Exiting...");
                System.exit(0);
            }

        } while (true);
    }
}
