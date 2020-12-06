package ss.week3.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ss.week3.bill.Bill;
import ss.week3.hotel.PricedSafe;

import static org.junit.jupiter.api.Assertions.*;

public class PricedSafeTest {

    private PricedSafe safe;
    private static final double PRICE = 6.36;
    private static final String PRICE_PATTERN = ".*6[.,]36.*";
    
    public String CORRECT_PASSWORD;
    public String WRONG_PASSWORD;
    

    @BeforeEach
    public void setUp() throws Exception {
        safe = new PricedSafe(PRICE);
        CORRECT_PASSWORD = safe.getPassword().getFactoryPassword();
        WRONG_PASSWORD = CORRECT_PASSWORD + "WRONG";
        assertFalse(safe.isActive());
        assertFalse(safe.isOpen());
    }
    
    @Test
    public void testIsBillItem() throws Exception {
    	assertTrue(safe instanceof Bill.Item,
    			"safe should be an instance of Bill.Item.");
        assertEquals(PRICE, safe.getAmount(), 0.001,
        		"GetAmount should return the price of the safe.");
    }

    @Test
    public void testGetAmount() {
        assertEquals(PRICE, safe.getAmount(), 0.001,
                "GetAmount should return the price of the safe.");
    }

    @Test
    public void testToString() {
        assertEquals(String.valueOf(PRICE), safe.toString(),
                "To string should be string version of price");
    }

    @Test
    public void testActivateSafeCorrectPass() {
        assertTrue(safe.activate(CORRECT_PASSWORD)); // Asserts that activating safe with correct password returns true
        assertTrue(safe.isActive()); // Asserts that safe is active
        assertFalse(safe.isOpen()); // Asserts that safe is closed
    }

    @Test
    public void testActivateSafeWrongPass() {
        assertFalse(safe.activate(WRONG_PASSWORD)); // Asserts that activating safe with wrong password returns false
        assertFalse(safe.isActive()); // Asserts that safe is still inactive
        assertFalse(safe.isOpen()); // Asserts that safe is still closed
    }

    @Test
    public void openDeactivatedSafeCorrectPass() {
        safe.open(CORRECT_PASSWORD); // Opening safe while it isn't active
        assertFalse(safe.isOpen()); // Assert that safe isn't open
        assertFalse(safe.isActive()); // Assert that safe isn't active
    }

    @Test
    public void openDeactivatedSafeWrongPass() {
        safe.open(WRONG_PASSWORD); // Opening safe with wrong password while it isn't active
        assertFalse(safe.isOpen()); // Assert that safe isn't open
        assertFalse(safe.isActive()); // Assert that safe isn't active
    }

    @Test
    public void testSafeOpening() {
        safe.activate(CORRECT_PASSWORD); // Activating safe with correct password
        safe.open(WRONG_PASSWORD); // Opening safe with wrong password
        assertFalse(safe.isOpen()); // Asserts that safe isn't opened

        safe.open(CORRECT_PASSWORD); // Opening safe with correct password
        assertTrue(safe.isActive()); // Asserts that safe is active
        assertTrue(safe.isOpen()); // Asserts that safe is open
    }

    @Test
    public void testSafeClosing() {
        safe.activate(CORRECT_PASSWORD);
        safe.open(CORRECT_PASSWORD);

        safe.close();
        assertTrue(safe.isActive()); // Asserts that safe is active
        assertFalse(safe.isOpen()); // Asserts that safe isn't opened
    }

    @Test
    public void testSafeCloseDeactivatedSafe() {
        safe.close();
        assertFalse(safe.isOpen()); // Assert that safe isn't open
        assertFalse(safe.isActive()); // Assert that safe isn't active
    }
}
