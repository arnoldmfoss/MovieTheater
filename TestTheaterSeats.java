import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class TestTheaterSeats {
    private int seatsInRow = 17;
    private int rows = 9;
    private int seatsLeft = seatsInRow * rows;


    @Test
    public void testCreate(){
        TheaterSeats ts = new TheaterSeats();
        assertFalse(ts == null);
        assertTrue(ts.getSeatsLeft() == seatsLeft);
        assertTrue(ts.getRows() == rows);
        assertTrue(ts.getSeatsInRow() == seatsInRow);
    }

    @Test
    public void testParse() throws NoSuchFieldException {
        try {
            Request rs = new Request("");
        } catch (NoSuchFieldException e) {
            assertEquals(e.getMessage(), "Not enough information.");
        }

        try {
            Request rs = new Request("1 ");
        } catch (NoSuchFieldException e) {
            assertEquals(e.getMessage(), "Not enough information.");
        }

        try {
            Request rs = new Request("1 0");
        } catch (NoSuchElementException e) {
            assertEquals(e.getMessage(), "Invalid input.");
        }

        Request rs = new Request("s 3");
        assertEquals(rs.getReservationNum(), "s");
        assertEquals(rs.getSeatsWanted(), 3);

    }

    @Test
    public void testMakeSeating(){
        TheaterSeats ts = new TheaterSeats();
        assertFalse(ts.makeReservation("none", seatsLeft+1));
        assertTrue(ts.makeReservation("first", 10));
        assertTrue(ts.getSeatsLeft() == seatsLeft-10);
    }

    @Test
    public void testPrint(){
        TheaterSeats ts = new TheaterSeats();
        assertTrue(ts.makeReservation("first", 10));
        assertEquals(ts.printSeating(), "first A1,A2,A3,A4,A5,A6,A7,A8,A9,A10\n");
        assertTrue(ts.makeReservation("second", 10));
        assertEquals(ts.printSeating(), "first A1,A2,A3,A4,A5,A6,A7,A8,A9,A10\n"+
                "second B1,B2,B3,B4,B5,B6,B7,B8,B9,B10\n");
    }
}
