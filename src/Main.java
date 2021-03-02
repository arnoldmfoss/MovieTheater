import java.nio.file.*;
import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<String, Integer> missed = new HashMap<>();
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        System.out.println("Input file path:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        File f = new File(input);
        Scanner fileScan = new Scanner(f);
        TheaterSeats openTheater = new TheaterSeats();
        String reservation = "";
        int numSeats = 0;
        while(fileScan.hasNextLine()){
            Request r = new Request(fileScan.nextLine());
            reservation = r.getReservationNum();
            numSeats = r.getSeatsWanted();
            if(!openTheater.makeReservation(reservation, numSeats)){
                missed.put(reservation, numSeats);
            }
        }

        Files.write(Paths.get("out.txt"), openTheater.printSeating().getBytes(), StandardOpenOption.CREATE);
        File newFile = new File ("out.text");
        System.out.println(newFile.getCanonicalPath());
    }
}
