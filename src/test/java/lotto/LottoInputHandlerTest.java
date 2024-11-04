package lotto;

import lotto.view.LottoInputHandler;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputHandlerTest {
    @Test
    void 유효하지_않은_입력이_들어오면_예외가_발생한다() {
        LottoInputHandler inputHandler = new LottoInputHandler();
        assertThatThrownBy(() -> inputHandler.parseInput("abc"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }
}