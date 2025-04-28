package org.apache.commons.text.SE4560_TESTS;

import org.apache.commons.text.CompositeFormat;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.*;

import static org.mockito.Mockito.*;

import java.text.Format;
import java.text.ParseException;
import static org.junit.jupiter.api.Assertions.*;

public class CompositeFormatTest {

    
    // Unit test
    @Test
    public void testReformat() throws ParseException {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        DecimalFormat parser = new DecimalFormat("#");
        CompositeFormat compositeFormatter = new CompositeFormat(parser, formatter);

        String input = "123";
        String result = compositeFormatter.reformat(input);
        assertEquals("123.00", result, "should be '123.00'");
    }


}
