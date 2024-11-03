package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.View.InputView;
import lotto.message.ErrorMessage;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 구매_금액_숫자가_아니면_예외_발생() {
        String input = "10j";

        assertThatThrownBy(() -> InputView.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 구매_금액_1000원_단위_아니면_예외_발생() {
        String input = "1023";

        assertThatThrownBy(() -> InputView.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_DIVISIBLE_ERROR_MESSAGE.getMessage());
    }

    @Test
    void 구매_금액_양수_아니면_예외_발생() {
        String input = "-1000";

        assertThatThrownBy(() -> InputView.validateMoneyToBuy(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_POSITIVE_ERROR_MESSAGE.getMessage());
    }
}
