package lotto;

import lotto.parser.WinningNumbersParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersParserTest {
    @Test
    @DisplayName("정상적인 경우 파싱")
    void 기능_테스트1() {
        assertThat(WinningNumbersParser.parse("1,32,25,3,44,41"))
                .containsOnly(1, 32, 25, 3, 44, 41);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"        "})
    @DisplayName("null, 빈 문자열, 공백 입력 시 예외 발생")
    void 예외_테스트1(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"one,two,three", "1:21,5,16,3,5", ";12ji08$9"})
    @DisplayName("아라비아 숫자와 구분자 이외의 값 입력 시 예외 발생")
    void 예외_테스트2(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구분자와 숫자만 입력 가능합니다. (예: 1,6,14,43,31,5)");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,14,32,43,44", "3,6,34,35,61,4", "13,5,0,3,13,2"})
    @DisplayName("로또 숫자 범위 이외의 값 입력 시")
    void 예외_테스트3(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1~45 사이의 숫자를 입력해야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", "1,2,3,4"})
    @DisplayName("중복된 값을 제외하고 6개 보다 많거나 적은 숫자가 입력되었을 시")
    void 예외_테스트4(String input) {
        assertThatThrownBy(() -> WinningNumbersParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 중복을 제외하고 6자리 숫자를 입력해야 합니다.");
    }
}
