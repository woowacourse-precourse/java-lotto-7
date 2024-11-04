package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @DisplayName("유효한 문자열 입력을 로또 번호 리스트로 변환한다.")
    @Test
    void 유효한_입력() {
        String input = "1,2,3,4,5,6";
        List<Integer> numbers = InputParser.winningNumParse(input);

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("잘못된 형식의 입력 시 예외가 발생한다.")
    @Test
    void 잘못된_입력_예외발생() {
        String input = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> InputParser.winningNumParse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 입력 시 예외가 발생한다.")
    @Test
    void 빈_입력_예외발생() {
        String input = "";

        assertThatThrownBy(() -> InputParser.winningNumParse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력 시 예외가 발생한다.")
    @Test
    void 숫자_아닌_입력_예외발생() {
        String input = "1,2,3,4,5,abc";

        assertThatThrownBy(() -> InputParser.winningNumParse(input))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
