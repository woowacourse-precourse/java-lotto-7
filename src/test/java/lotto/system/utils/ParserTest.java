package lotto.system.utils;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.system.unit.LottoNumber;
import lotto.system.unit.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

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
        String input = "1,2,3";
        List<Integer> expected = List.of(1, 2, 3);

        // when
        List<Integer> result = Parser.parseWithDelimiter(input);

        // then
        assertEquals(expected, result, "기본 쉼표 구분자를 사용하여 문자열을 정수 리스트로 변환한 결과가 예상과 일치하지 않습니다.");
    }

    @DisplayName("LottoTicket 리스트를 구분자로 연결된 문자열로 변환 테스트")
    @Test
    void joinWithDelimiterTest() {
        // given
        List<LottoTicket> tickets = List.of(
                LottoTicket.ofLottoNumbers(
                        List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4),
                                LottoNumber.of(5), LottoNumber.of(6))),
                LottoTicket.ofLottoNumbers(
                        List.of(LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10),
                                LottoNumber.of(11), LottoNumber.of(12)))
        );
        String delimiter = ";";

        // when
        String result = Parser.joinWithDelimiter(tickets, delimiter);

        // then
        assertThat(result).isEqualTo("[1, 2, 3, 4, 5, 6]; [7, 8, 9, 10, 11, 12]");
    }

    @DisplayName("구분자를 사용한 문자열을 정수 리스트로 변환 테스트")
    @Test
    void parseWithDelimiterTest() {
        // given
        String input = "1,2,3,4,5,6";
        String delimiter = ",";

        // when
        List<Integer> result = Parser.parseWithDelimiter(input, delimiter);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("기본 구분자를 사용한 문자열을 정수 리스트로 변환 테스트")
    @Test
    void parseWithDefaultDelimiterTest() {
        // given
        String input = "7,8,9,10,11,12";

        // when
        List<Integer> result = Parser.parseWithDelimiter(input);

        // then
        assertThat(result).containsExactly(7, 8, 9, 10, 11, 12);
    }
}