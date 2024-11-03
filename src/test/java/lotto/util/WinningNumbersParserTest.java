package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersParserTest {

    @Test
    void 정상적인_입력에_대한_파싱() {
        // Given
        String input = "1, 2, 3, 4, 5, 6";

        // When
        List<Integer> result = WinningNumbersParser.parse(input);

        // Then
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, result);
    }

    @Test
    void 공백있는_입력에_대한_파싱() {
        // Given
        String input = "10 , 20 , 30 , 40 , 50 , 60";

        // When
        List<Integer> result = WinningNumbersParser.parse(input);

        // Then
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50, 60);
        assertEquals(expected, result);
    }
}