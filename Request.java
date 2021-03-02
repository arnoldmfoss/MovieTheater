import java.util.NoSuchElementException;

public class Request {
    private String reservationNum;
    private int seatsWanted;

    public Request(String input) throws NoSuchFieldException {
        String[] split = input.split(" ");

        if(split.length != 2){
            throw new NoSuchFieldException("Not enough information.");
        }

        reservationNum = split[0];
        seatsWanted = Integer.parseInt(split[1]);

        if(reservationNum == null || seatsWanted < 1){
            reservationNum = null;
            seatsWanted = 0;
            throw new NoSuchElementException("Invalid input.");
        }
    }

    public String getReservationNum(){
        return reservationNum;
    }

    public int getSeatsWanted(){
        return seatsWanted;
    }

}
