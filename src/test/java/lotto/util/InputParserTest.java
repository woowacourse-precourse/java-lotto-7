package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    @DisplayName("쉼표로 구분된 숫자 문자열을 List<Integer>로 변환하는 테스트")
    void 숫자_문자열을_List로_변환() {
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = InputParser.parseToNumbers(input);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @Test
    @DisplayName("숫자 앞뒤에 공백이 포함된 경우에도 올바르게 변환되는지 테스트")
    void 숫자_앞뒤에_공백이_있는_경우() {
        String input = "  1 ,   2,   3, 4, 5,   6   ";
        List<Integer> numbers = InputParser.parseToNumbers(input);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }
}