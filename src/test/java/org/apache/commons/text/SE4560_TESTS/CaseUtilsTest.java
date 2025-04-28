package org.apache.commons.text.SE4560_TESTS;

import org.apache.commons.text.CaseUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CaseUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "hellO/world, helloWorld",
            "camel-case, camelCase",
            "Number, number",
            "Hello \uD83D\uDE00, hello\uD83D\uDE00",
            "hi, hi"
    })
    void testToCamelCase(String input, String expected) {
        char[] delimiters = {'/', '-'};
        assertEquals(expected, CaseUtils.toCamelCase(input, false, delimiters));
    }

    // Other test for null input
    @Test
    void testToCamelCaseNullInput() {
        assertNull(CaseUtils.toCamelCase(null, false));
    }

    @Test
    void testToCamelCaseMultipleDelimiters() {
        String input = "hello--world---again";
        char[] delimiters = {'-', ' '};
        String expected = "helloWorldAgain";
        String actual = CaseUtils.toCamelCase(input, false, delimiters);
        assertEquals(expected, actual, "Expected 'helloWorldAgain' but got " + actual);
    }


}
