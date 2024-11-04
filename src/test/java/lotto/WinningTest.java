package lotto;

import static lotto.Constants.ERROR_HEADER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningTest {

    @DisplayName("당첨 번호는 6개의 숫자이다.")
    @Test
    void 당첨_번호는_여섯개의_숫자이다() {
        assertDoesNotThrow(() -> Winning.from("1,2,3,4,5,6"));
    }

    @DisplayName("당첨 번호가 6개 미만의 개수일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_여섯개_미만의_개수일_경우_예외가_발생한다() {
        assertWinningThrows("1,2,3,4,5");
    }

    @DisplayName("당첨 번호가 6개 초과의 개수일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_여섯개_초과의_개수일_경우_예외가_발생한다() {
        assertWinningThrows("1,2,3,4,5,6,7");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있을_경우_예외가_발생한다() {
        assertWinningThrows("1,2,3,4,6,6");
    }

    @DisplayName("당첨 번호의 숫자 범위는 1~45이다.")
    @Test
    void 당첨_번호의_숫자_범위는_일에서_사십오_사이이다() {
        assertDoesNotThrow(() -> Winning.from("1,5,15,25,35,45"));
    }

    @DisplayName("당첨 번호가 1 미만일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_일_미만일_경우_예외가_발생한다() {
        assertWinningThrows("-1,2,3,4,5,6");
        assertWinningThrows("0,2,3,4,5,6");
    }

    @DisplayName("당첨 번호가 45를 초과할 경우 예외가 발생한다.")
    @Test
    void 당첨_번호가_사십오를_초과할_경우_예외가_발생한다() {
        assertWinningThrows("1,2,3,4,5,46");
        assertWinningThrows("1,2,3,4,5,200000000000");
    }

    @DisplayName("당첨 번호는 쉼표(,)를 기준으로 구분한다.")
    @Test
    void 당첨_번호는_쉼표를_기준으로_구분한다() {
        Winning winning = Winning.from("1,2,3,4,5,6");

        List<Integer> numbers = winning.getNumbers();

        assertIterableEquals(List.of(1, 2, 3, 4, 5, 6), numbers);
    }

    @DisplayName("당첨 번호의 쉼표(,) 사이에 아무 숫자가 없을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_쉼표_사이에_아무_숫자가_없을_경우_예외가_발생한다() {
        assertWinningThrows(",1,2,3,4,5,6");
        assertWinningThrows("1,,2,3,4,5,6");
        assertWinningThrows("1,2,3,4,5,6,");
        assertWinningThrows("1,2,3,4,5,6,,");
    }

    @DisplayName("당첨 번호에 숫자와 쉼표를 제외한 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_숫자와_쉼표를_제외한_문자가_입력될_경우_예외가_발생한다() {
        assertWinningThrows("1, 2, 3, 4, 5, 45");
        assertWinningThrows("*,2,3,4,5,45");
        assertWinningThrows("1*2*3*4*5*45");
    }

    @DisplayName("당첨 번호에 아무것도 입력되지 않을 경우 예외가 발생한다.")
    @Test
    void 당첨_번호에_아무것도_입력되지_않을_경우_예외가_발생한다() {
        assertWinningThrows("");
    }

    @DisplayName("당첨 번호가 null일 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_null일_경우_예외가_발생한다() {
        assertWinningThrows(null);
    }

    void assertWinningThrows(String input) {
        assertThatThrownBy(() -> Winning.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEADER);
    }
}
