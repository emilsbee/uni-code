package ss.week2.test;

import ss.week2.ThreeWayLamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeWayLampTest {
    private ThreeWayLamp lamp;

    public static void main(String[] args) {
        ThreeWayLampTest testSuit = new ThreeWayLampTest();
        testSuit.runTest();
    }

    public void runTest () {
        setUp();
        testInitialState();
        testNextState();
    }

    public void setUp() {
        lamp = new ThreeWayLamp();
    }

    public void testInitialState() {
        assertEquals("OFF", lamp.getLampState());
    }

    public void testNextState() {
        assertEquals("LOW", lamp.getNextLampState());
        lamp.setLampState("LOW");

        assertEquals("MEDIUM", lamp.getNextLampState());
        lamp.setLampState("MEDIUM");

        assertEquals("HIGH", lamp.getNextLampState());
        lamp.setLampState("HIGH");

        assertEquals("OFF", lamp.getNextLampState());
    }
}
