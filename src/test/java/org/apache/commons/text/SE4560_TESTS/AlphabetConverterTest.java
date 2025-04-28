package org.apache.commons.text.SE4560_TESTS;

import java.io.UnsupportedEncodingException;

import org.apache.commons.text.AlphabetConverter;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AlphabetConverterTest {

    // SVT: Test encoding with null input
//    @Test
//    void testNull() throws UnsupportedEncodingException {
//
//    }

    // SVT: CJK Support
    @ParameterizedTest
    @CsvSource({
            "あ, ア",
            "い, イ",
            "う, ウ",
            "え, エ",
            "お, オ"
    })
    void testEncodeDecodeCJK(String inputChar, String expectedChar) throws UnsupportedEncodingException {
        Character[] initialChars = {'あ','い','う','え','お'};
        Character[] finalChars = {'ア','イ','ウ','エ','オ'};
        Character[] ignoreChars = {};

        AlphabetConverter converter = AlphabetConverter.createConverterFromChars(initialChars, finalChars, ignoreChars);
        assertEquals(expectedChar, converter.encode(inputChar));
    }

    @Test
    public void testEquality() {
        Character[] originals = {'a', 'b', 'c', 'd'};
        Character[] encoding = {'0', '1', '2'};
        Character[] doNotEncode = {'d'};

        AlphabetConverter converter1 = AlphabetConverter.createConverterFromChars(originals, encoding, doNotEncode);
        AlphabetConverter converter2 = AlphabetConverter.createConverterFromChars(originals, encoding, doNotEncode);
        assertEquals(converter1, converter2); // same input so same result should occur
    }

}
