package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.Domain.PurchaseAmount;
import lotto.Messages.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(strings = {""})
    public void 구입_금액_입력값이_빈_문자열이면_예외처리(String input) {

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EMPTY_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n"})
    public void 구입_금액_입력값이_공백문자만_있으면_예외처리(String input) {

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BLANK_PURCHASE_AMOUNT.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1원", "1.0"})
    public void 구입_금액_입력값이_숫자아닌_문자가_있으면_예외처리(String input) {

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMERIC_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    public void 구입_금액_입력값이_정수범위가_아니면_예외처리() {
        String input = String.valueOf(Integer.MAX_VALUE + 1L);

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_PURCHASE_AMOUNT.getMessage());
    }

}
