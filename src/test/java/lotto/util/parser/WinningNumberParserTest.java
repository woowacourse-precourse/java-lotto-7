package lotto.util.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumberParserTest {
    @DisplayName("정수와 콤마로 이루어진 문자열이 들어올 경우 정수가 들어간 리스트가 반환되어야 한다.")
    @Test
    void parseWinningNumbers() {
        //given
        String rawWinningNumber = "1,2,3,4, 5,6";

        //when
        List<Integer> winningNumbers = WinningNumberParser.parseRawWinningNumbers(rawWinningNumber);

        //then
        assertThat(winningNumbers).hasSize(6)
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("정수형 범위가 넘어선 숫자가 들어있는 문자열이 입력될 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"2147483648,1,2,3", "1,2,3,4,-2147483649"})
    void inputInvalidRangeNumber(String rawWinningNumber) {

        assertThatThrownBy(() -> WinningNumberParser.parseRawWinningNumbers(rawWinningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호 입력시 정수형 범위를 넘어선 숫자가 포함된 문자열을 입력할 수 없습니다.");
    }
}