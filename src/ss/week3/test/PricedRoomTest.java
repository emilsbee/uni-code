package ss.week3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.hotel.PricedRoom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PricedRoomTest {
    private Bill.Item item;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";

    @BeforeEach
    public void setUp() throws Exception {
        item = new PricedRoom(0, PRICE, 0);
    }

    @Test
    public void testGetAmount() throws Exception {
        assertEquals(PRICE, item.getAmount(), 0, 
        		"GetAmount should return the price of the room.");
    }

    @Test
    public void testToString() throws Exception {
        assertTrue(item.toString().matches(PRICE_PATTERN), 
        		"The price per night should be included.");
    }
}
