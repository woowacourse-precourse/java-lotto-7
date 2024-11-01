package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator purchaseAmountValidator;

    @Test
    @DisplayName("구입 금액이 숫자인지 확인")
    void 구입_금액_숫자_테스트() {
        assertThatThrownBy(() -> {
            purchaseAmountValidator = new PurchaseAmountValidator("abc");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액은(는) 숫자 형식이어야 합니다.");
    }
}
