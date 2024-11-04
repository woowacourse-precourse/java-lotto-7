package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

class WinningNumberTest {
    @Test
    void 당첨_번호를_쉼표로_구분하여_입력하지_않으면_예외가_발생한다() {
        //given
        final String expectedMessage = "[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분한 숫자들이어야 합니다.";
        final String winningNumber = "1,2:3,4*5;6";

        //when & then
        assertThatThrownBy(() -> new WinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    @Test
    void 쉼표를_포함한_당첨_번호를_넣으면_객체가_만들어진다() {
        //given
        final String winningNumber = "1,2,3,4,5,6";

        //when & then
        assertDoesNotThrow(() -> new WinningNumber(winningNumber));
    }
}