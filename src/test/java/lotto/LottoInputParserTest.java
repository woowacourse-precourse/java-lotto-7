package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputParserTest {
    @DisplayName("금액이 숫자 이외의 입력을 받을 경우 예외 발생")
    @Test
    void 입력_변환_기능_테스트_1() {
        assertThatThrownBy(() -> InputParser.parsePrice("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 입력 시 숫자 배열로 변환")
    @Test
    void 입력_변환_기능_테스트_2() {
        String[] input = {"1", "2", "3", "4", "5", "6"};
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertThat(InputParser.getIntArray(input)).containsExactly(expected);
    }

    @DisplayName("로또 번호가 숫자 이외의 입력을 받을 경우 예외 발생")
    @Test
    void 입력_변환_기능_테스트_3() {
        String[] input = {"1", "2", "abc", "4", "5", "6"};
        assertThatThrownBy(() -> InputParser.getIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 공백 입력을 받을 경우 예외 발생")
    @Test
    void 입력_변환_기능_테스트_4() {
        String[] input = {"1", "2", "", "4", "5", "6"};
        assertThatThrownBy(() -> InputParser.getIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
