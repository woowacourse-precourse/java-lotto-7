package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputTest {
    @DisplayName("숫자가 아닌 입력을 받을 경우 예외가 발생한다")
    @Test
    void 숫자가_아닌_입력_예외_테스트() {
        assertThatThrownBy(() -> InputParser.parsePrice("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 입력 시 숫자 배열로 변환된다")
    @Test
    void 정상_입력_변환_테스트() {
        String[] input = {"1", "2", "3", "4", "5", "6"};
        int[] expected = {1, 2, 3, 4, 5, 6};
        assertThat(InputParser.getIntArray(input)).containsExactly(expected);
    }

    @DisplayName("입력 값에 유효하지 않은 값이 있으면 예외가 발생한다")
    @Test
    void 유효하지_않은_값_테스트() {
        String[] input = {"1", "2", "abc", "4", "5", "6"};
        assertThatThrownBy(() -> InputParser.getIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 값이 빈 문자열이면 예외가 발생한다")
    @Test
    void 빈_문자열_테스트() {
        String[] input = {"1", "2", "", "4", "5", "6"};
        assertThatThrownBy(() -> InputParser.getIntArray(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
