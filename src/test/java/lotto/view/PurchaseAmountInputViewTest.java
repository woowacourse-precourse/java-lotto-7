package lotto.view;

import static lotto.ExceptionMessage.PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PurchaseAmountInputViewTest {
    PurchaseAmountInputView purchaseAmountInputView;

    @BeforeEach
    void init() {
        purchaseAmountInputView = new PurchaseAmountInputView();
    }

    @Test
    void 구입금액이_숫자로만_이루어진_문자열이_아니라면_예외가_발생한다() {
        String input = "5000원";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(() ->
                purchaseAmountInputView.getPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_NUMERIC_EXCEPTION.message());
    }
}
