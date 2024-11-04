package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class ParserTest {

    @DisplayName("쉼표(,)로 구분된 숫자 문자열을 파싱하여 숫자 리스트로 변환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "'1,2', 2",
            "'1,2,3', 3",
            "',', 0",
            "'10,20,30', 3"
    })
    void 숫자_파싱_테스트(String input, int expectedSize) {
        Parser parser = new Parser();
        List<Integer> result = parser.ParseWinningNumber(input);

        Assertions.assertThat(result.size()).isEqualTo(expectedSize);
    }

    @DisplayName("숫자가 아닌 입력일 경우 예외 발생 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "j",
            "한글",
            "''"
    })
    void 예외_발생_테스트(String input) {
        Parser parser = new Parser();
        Assertions.assertThatThrownBy(() -> parser.ParseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}