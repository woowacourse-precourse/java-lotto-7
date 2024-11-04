package lotto.controller.inputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumbersValidatorTest {
    @Test
    void 당첨번호가_공백일_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                WinningNumbersValidator.validate(" ")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호를 입력해주세요.");
    }

    @Test
    void 당첨번호가_숫자가_아닐_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                WinningNumbersValidator.validate("1, 2, a, 4, 5, 6")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자여야 합니다.");
    }

    @Test
    void 당첨번호에_중복된_숫자가_있을_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                WinningNumbersValidator.validate("1, 2, 3, 3, 5, 6")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호에는 중복된 숫자가 있을 수 없습니다.");
    }

    @Test
    void 당첨번호가_6개가_아닌_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                WinningNumbersValidator.validate("1, 2, 3, 4, 5")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨번호가_범위를_벗어난_경우_예외가_발생해야_한다() {
        assertThatThrownBy(() ->
                WinningNumbersValidator.validate("1, 2, 3, 4, 5, 50")
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 당첨번호가_유효한_경우_정상적으로_변환되어야_한다() {
        List<Integer> result = WinningNumbersValidator.validate("1, 2, 3, 4, 5, 6");
        assertEquals(List.of(1, 2, 3, 4, 5, 6), result);
    }
}