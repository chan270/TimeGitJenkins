import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    // getTotalSeconds tests - tested boundaries separately, good, and bad tests
    @Test
    void testGetTotalSecondsGood() {
        int seconds = Time.getTotalSeconds("05:05:05:005");
        assertTrue(seconds == 18305, "The total seconds were not calculated properly");
    }

    @Test
    void testGetTotalSecondsUpperBoundary() {
        int seconds = Time.getTotalSeconds("23:59:59:005");
        assertTrue(seconds == 86399, "The total seconds were not calculated properly for upper boundary"
                    +"(86399 seconds for 23:59:59)");
    }

    @Test
    void testGetTotalSecondsLowerBoundary() {
        int seconds = Time.getTotalSeconds("00:00:00:005");
        assertTrue(seconds == 0, "The total seconds were not calculated properly for lower boundary"
                +"(0 seconds for 00:00:00)");
    }

    @Test
    void testGetTotalSecondsBad() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getTotalSeconds("10:00");}
        );
    }

    // getTotalMinutes tests - tested boundaries and good together using @ParameterizedTest, and bad tests
    @ParameterizedTest
    @ValueSource (strings = { "23:05:36:001", "23:05:00:000", "23:05:59:999"})
    void testGetTotalMinutesGoodAndBoundary(String candidate) {
        int minutes = Time.getTotalMinutes(candidate);
        assertTrue(minutes == 5,"The minutes were not calculated properly");
    }

    @Test
    void testGetTotalMinutesBad() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getTotalMinutes("09:0");}
        );
    }

    // getTotalHours tests - tested boundaries and good together using @ParameterizedTest, and bad tests
    @ParameterizedTest
    @ValueSource (strings = { "23:05:36:004", "23:00:00:000", "23:59:59:999"})
    void testGetTotalHoursGoodAndBoundary(String candidate) {
        int hours = Time.getTotalHours(candidate);
        assertTrue(hours == 23,"The hours were not calculated properly");
    }

    @Test
    void testGetTotalHoursBad() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getTotalHours(":00:00");}
        );
    }

    // getSeconds tests - tested boundaries separately, good, and bad tests
    @Test
    void testGetSecondsGood() {
        int seconds = Time.getSeconds("19:20:16:005");
        assertTrue(seconds == 16, "The seconds were not calculated properly");
    }

    @Test
    void testGetSecondsUpperBoundary() {
        int seconds = Time.getSeconds("21:30:59:007");
        assertTrue(seconds == 59, "The seconds were not calculated properly for upper boundary"
                +"(59 seconds for 21:30:59:007)");
    }

    @Test
    void testGetSecondsLowerBoundary() {
        int seconds = Time.getSeconds("15:45:00:122");
        assertTrue(seconds == 0, "The seconds were not calculated properly for lower boundary"
                +"(0 seconds for 15:45:00:122");
    }

    @Test
    void testGetSecondsBad() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getSeconds(":00:00:99");}
        );
    }

    @Test
    void testGetMillisecondsGood() {
        int milliseconds = Time.getMilliseconds("10:59:59:005");
        assertTrue(milliseconds == 5,"The milliseconds were not calculated properly");
    }

    @Test
    void testGetMillisecondsUpperBoundary() {
        int milliseconds = Time.getMilliseconds("21:30:59:999");
        assertTrue(milliseconds == 999, "The milliseconds were not calculated properly for upper boundary"
                +"(999 milliseconds for 21:30:59:999)");
    }

    @Test
    void testGetMillisecondsLowerBoundary() {
        int milliseconds = Time.getMilliseconds("23:22:41:000");
        assertTrue(milliseconds == 0, "The milliseconds were not calculated properly for upper boundary"
                +"(000 milliseconds for 23:22:41:000)");
    }

    @Test
    void testGetMilliSecondsBad() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getMilliseconds("00:00:00:01");}
        );
    }

    @Test
    void testGetMilliSecondsExceptional() {
        assertThrows(
                NumberFormatException.class,
                ()->{Time.getMilliseconds("00:00:00:0111");}
        );
    }

}