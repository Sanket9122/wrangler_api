package io.cdap.wrangler.api.parser;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ByteSizeTest {

    @Test
    public void testGetBytes() {
        ByteSize byteSize = new ByteSize("10KB");
        assertEquals(10240, byteSize.getBytes());
        
        byteSize = new ByteSize("1MB");
        assertEquals(1048576, byteSize.getBytes());
        
        byteSize = new ByteSize("500B");
        assertEquals(500, byteSize.getBytes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInput() {
        new ByteSize("invalid");
    }
}
