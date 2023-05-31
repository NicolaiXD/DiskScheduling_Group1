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

        while (true) {
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

            if (!choice.matches("[A-Ga-g]")) {
                System.out.println("Invalid choice! Please select a valid option.");
                continue;
            }

            if (choice.equalsIgnoreCase("G")) {
                System.out.println("Exiting...");
                System.exit(0);
            }

            do {
            System.out.print("Input Track Size: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.print("Input Track Size: ");
                scanner.next();
            }
            track_size = scanner.nextInt();
            } while (track_size < 1);
            
            do {
            System.out.print("Input Current Position: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.print("Input Current Position: ");
                scanner.next();
            }
            current_position = scanner.nextInt();
            } while (current_position < 0 || current_position > track_size);
            
            do {
                System.out.print("Input number of requests (1 to 10): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    System.out.print("Input number of requests (1 to 10): ");
                    scanner.next();
                }
                num_requests = scanner.nextInt();
            } while (num_requests < 1 || num_requests > 10);

            System.out.println("Input the requests:");
            requests = new int[num_requests];

            for (int i = 1; i <= num_requests; i++) {
                do {
                    System.out.print("Loc " + i + ": ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a number.");
                        System.out.print("Loc " + i + ": ");
                        scanner.next();
                    }
                    requests[i-1] = scanner.nextInt();
                } while (requests[i-1] < 0 || requests[i-1] > track_size - 1);
            }

            switch (choice.toUpperCase()) {
                case "A":
                    System.out.println("You chose First Come First Serve");
                    head_movement = fcfs(current_position, track_size, requests);
                    break;
                case "B":
                    System.out.println("You chose Shortest Seek Time First");
                    head_movement = sstf(current_position, track_size, requests);
                    break;
                case "C":
                    System.out.println("You chose Scan");
                    head_movement = scan(current_position, track_size, requests);
                    break;
                case "D":
                    System.out.println("You chose Look");
                    head_movement = Look.main(current_position, track_size, requests);
                    break;
                case "E":
                    System.out.println("You chose CScan");
                    head_movement = CScan.main(current_position, track_size, requests);
                    break;
                case "F":
                    System.out.println("You chose CLook");
                    head_movement = CLook.main(current_position, track_size, requests);
                    break;
            }

            System.out.println("Total head movement: " + head_movement);
            double seekTime = head_movement / num_requests;
            System.out.println("Seek Time: " + head_movement);
            
            System.out.print("Input again (Y/N)? ");
            String repeat = scanner.next();

            if (!repeat.equalsIgnoreCase("y")) {
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
    }
}