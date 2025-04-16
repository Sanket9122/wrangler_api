package io.cdap.wrangler.api.parser;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TimeDurationTest {

    @Test
    public void testGetMilliseconds() {
        TimeDuration timeDuration = new TimeDuration("150ms");
        assertEquals(150, timeDuration.getMilliseconds());
        
        timeDuration = new TimeDuration("2s");
        assertEquals(2000, timeDuration.getMilliseconds());
        
        timeDuration = new TimeDuration("1min");
        assertEquals(60000, timeDuration.getMilliseconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        new TimeDuration("invalid");
    }
}
