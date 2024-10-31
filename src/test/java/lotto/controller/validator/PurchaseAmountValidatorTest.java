package lotto.controller.validator;

import static lotto.exception.InvalidAmountException.INVALID_AMOUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.InvalidAmountException;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @Test
    void 유효한_구입_금액일_때_예외가_발생하지_않는다() {
        int validAmount = LottoConstants.LOTTO_PURCHASE_AMOUNT * 5;

        PurchaseAmountValidator validator = new PurchaseAmountValidator(validAmount);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 유효하지_않은_구입_금액일_때_예외가_발생한다() {
        int invalidAmount = LottoConstants.LOTTO_PURCHASE_AMOUNT * 5 + 500;

        PurchaseAmountValidator validator = new PurchaseAmountValidator(invalidAmount);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(InvalidAmountException.class)
                .hasMessage(INVALID_AMOUNT_MESSAGE);
    }
}