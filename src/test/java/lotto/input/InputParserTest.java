package lotto.input;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    InputParser inputParser = new InputParser();
    @Test
    void 당첨번호_파싱_테스트(){
        String input = "1, 2, 3, 4, 5, 6";
        List<Integer> result = inputParser.splitWinningNumbers(input);
        assertEquals(6, result.size());
        assertIterableEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

}