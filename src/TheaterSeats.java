import java.util.*;

public class TheaterSeats {
    private int seatsLeft;
    private int seatsInRow;
    private int rows;
    private HashMap<Character, int[]> mapOfSeating;
    private HashMap<Character, Integer> seatsLeftInRow;
    private TreeMap<String, ArrayList<String>> seatsAssigned;

    public TheaterSeats(){
        seatsInRow = 17;
        rows = 9;
        seatsLeft = seatsInRow * rows;
        mapOfSeating = new HashMap<>();
        seatsLeftInRow = new HashMap<>();
        seatsAssigned = new TreeMap<>();
        makeSeatingChart();
    }

    private void makeSeatingChart(){
        char letter = 'A';
        for (int i = 0; i<rows; i++){
            mapOfSeating.put(letter, new int[seatsInRow]);
            seatsLeftInRow.put(letter, seatsInRow);
            letter++;
        }
    }

    public boolean makeReservation(String reservation, int seats){
        if(!isAvailable(seats)){
            return false;
        }
        for (Character c : seatsLeftInRow.keySet()){
            int seatsAvailable = seatsLeftInRow.get(c);
            if(seatsAvailable >= seats){
                for(int i = 0; i<seatsInRow && seats>0; i++){
                    if(mapOfSeating.get(c)[i] == 0){
                        mapOfSeating.get(c)[i] = 1;
                        if(!seatsAssigned.containsKey(reservation)){
                            ArrayList<String> lst = new ArrayList<>();
                            lst.add(c + Integer.toString(i+1));
                            seatsAssigned.put(reservation, lst);
                        }else{
                            ArrayList<String> lst = seatsAssigned.get(reservation);
                            lst.add(c + Integer.toString(i+1));
                        }
                        seatsLeft--;
                        seatsAvailable--;
                        seats--;
                        seatsLeftInRow.put(c, seatsAvailable);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private boolean isAvailable(int seats){
        return seatsLeft>=seats;
    }

    public int getSeatsLeft(){
        return seatsLeft;
    }

    public int getRows(){
        return rows;
    }

    public int getSeatsInRow(){
        return seatsInRow;
    }

    public String printSeating(){
        String out = "";
        for(String reservations: seatsAssigned.keySet()){
            ArrayList<String> seats = seatsAssigned.get(reservations);
            out += reservations + " " + seats.get(0);
            for(int i = 1; i<seats.size(); i++){
                out += "," + seats.get(i);
            }
            out += "\n";
        }
        return out;
    }

}
