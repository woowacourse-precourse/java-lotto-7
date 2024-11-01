package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountValidatorTest {
    private PurchaseAmountValidator purchaseAmountValidator;

    @Test
    @DisplayName("구입 금액에 공백이 포함되었는지 확인")
    void 구입_금액_공백_테스트() {
        assertThatThrownBy(() -> {
            purchaseAmountValidator = new PurchaseAmountValidator(" 3000");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액에 공백을 허용하지 않습니다.");
    }

    @Test
    @DisplayName("구입 금액이 숫자인지 확인")
    void 구입_금액_숫자_테스트() {
        assertThatThrownBy(() -> {
            purchaseAmountValidator = new PurchaseAmountValidator("abc");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 구입 금액은(는) 숫자 형식이어야 합니다.");
    }
}
