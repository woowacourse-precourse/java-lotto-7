package lotto;

import lotto.view.LottoInputHandler;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputHandlerTest {
    @Test
    void 정수가_아닌_입력이_들어오면_예외가_발생한다() {
        LottoInputHandler inputHandler = new LottoInputHandler();
        assertThatThrownBy(() -> inputHandler.parseInput("abc"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }

    @Test
    void 정수_리스트가_아닌_입력이_들어오면_예외가_발생한다() {
        LottoInputHandler inputHandler = new LottoInputHandler();
        String invalidInput = "1, 2, three, 4, 5, 6";

        assertThatThrownBy(() -> inputHandler.parseNumberList(invalidInput))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }
}