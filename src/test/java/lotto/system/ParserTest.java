package lotto.system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.system.utils.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("정수 리스트를 쉼표로 이어붙이기 테스트")
    void joinWithDelimiter_ShouldJoinListWithComma() {
        // given
        List<Integer> input = List.of(1, 2, 3);
        String expected = "1, 2, 3";

        // when
        String result = Parser.joinWithDelimiter(input, ",");

        // then
        assertEquals(expected, result, "리스트를 쉼표로 이어붙인 결과가 예상과 일치하지 않습니다.");
    }

    @Test
    @DisplayName("구분자로 구분된 문자열을 정수 리스트로 변환하는 테스트")
    void parseWithDelimiter_ShouldParseStringToListOfIntegers() {
        // given
        String input = "1;2;3";
        List<Integer> expected = List.of(1, 2, 3);

        // when
        List<Integer> result = Parser.parseWithDelimiter(input, ";");

        // then
        assertEquals(expected, result, "구분자로 구분된 문자열을 정수 리스트로 변환한 결과가 예상과 일치하지 않습니다.");
    }

    @Test
    @DisplayName("기본 쉼표 구분자를 사용하여 문자열을 정수 리스트로 변환하는 테스트")
    void parseWithDefaultDelimiter_ShouldParseStringToListOfIntegers() {
        // given
        String input = "4,5,6";
        List<Integer> expected = List.of(4, 5, 6);

        // when
        List<Integer> result = Parser.parseWithDelimiter(input);

        // then
        assertEquals(expected, result, "기본 쉼표 구분자를 사용하여 문자열을 정수 리스트로 변환한 결과가 예상과 일치하지 않습니다.");
    }
}