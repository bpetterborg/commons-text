package org.apache.commons.text.SE4560_TESTS;

import org.apache.commons.text.FormattableUtils;
import org.junit.jupiter.api.Test;

import java.util.Formatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormattableUnitsTest {
    @Test
    public void testAppendWithPaddingAndTruncation() {
        String input = "Tasdfa3412.33412334";
        String expected = "----------Tasdfa3412";
        Formatter formatter = new Formatter();

        // truncate with precision 10, length 20
        FormattableUtils.append(input, formatter, 0, 20, 10, '-');
        assertEquals(expected, formatter.toString());
    }

    // Now with ellipsis
    @Test
    public void testAppendTruncateEllipsis() {
        String input = "The quick brown fox jumps over the lazy dog";
        String expected = "          The qui...";

        Formatter formatter = new Formatter();

        // Test whether ellipsis is added
        FormattableUtils.append(input, formatter, 0, 20, 10, ' ', "...");
        assertEquals(expected, formatter.toString());
    }

}
