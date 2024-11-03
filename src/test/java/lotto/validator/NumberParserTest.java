package lotto.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    @DisplayName("실패 - 숫자가 아닌 경우")
    void 숫자_파싱_테스트_숫자_아닌_경우() {
        String input = "1,2,3,4,5,a";

        assertThrows(NumberFormatException.class,
                () -> NumberParser.toNumbers(input),
                "[ERROR] 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("실패 - 공백이거나 빈 값일 경우")
    void 숫자_파싱_테스트_공백_빈값() {
        String input1 = "";
        String input2 = " ";

        assertThrows(NumberFormatException.class,
                () -> NumberParser.toNumbers(input1),
                "[ERROR] 숫자를 입력해 주세요."
        );
        assertThrows(NumberFormatException.class,
                () -> NumberParser.toNumbers(input2),
                "[ERROR] 숫자를 입력해 주세요."
        );
    }

    @Test
    @DisplayName("성공 - 정상 입력")
    void 숫자_파싱_테스트_정상() {
        String input = "1,2,3,4,5,6";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(expected, NumberParser.toNumbers(input));
    }

    @Test
    @DisplayName("성공 - 앞,뒤,사이 공백이 있을 경우")
    void 숫자_파싱_테스트_앞뒤사이_공백() {
        String input = "1, 2,3 , 4,5 , 6 ";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(expected, NumberParser.toNumbers(input));
    }
}