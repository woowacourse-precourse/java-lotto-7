package lotto.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.view.parser.InputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    @Test
    @DisplayName("입력받은 수를 정수로 변환한다.")
    void parseInteger() {
        InputParser inputParser = new InputParser();
        assertEquals(1000, inputParser.parseInteger("1000"));
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseInteger("abc"));
    }

    @Test
    @DisplayName("당첨 번호 파싱 테스트")
    void parseWinningNumbers() {
        InputParser inputParser = new InputParser();
        String input = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expectedNumbers, inputParser.parseWinningNumbers(input));

        String invalidInput = "1,2,3,abc,5,6";
        assertThrows(IllegalArgumentException.class, () -> inputParser.parseWinningNumbers(invalidInput));
    }

}
