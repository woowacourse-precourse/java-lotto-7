package lotto.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountValidatorTest {

    @DisplayName("정상적인 구매금액을 입력하는 경우 false를 반환한다")
    @Test
    void 정상적인_구매금액을_입력하는_경우_false를_반환한다() {
        // given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String userInput = "5000";

        // when
        boolean result = purchaseAmountValidator.isNotValidPurchaseAmount(userInput);

        // then
        assertThat(result).isFalse();
    }

    @DisplayName("숫자가 아닌 값을 입력하는 경우 true를 반환한다")
    @Test
    void 숫자가_아닌_값을_입력하는_경우_true를_반환한다() {
        // given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String userInput = "aaa";

        // when
        boolean result = purchaseAmountValidator.isNotValidPurchaseAmount(userInput);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("천원보다 적은 금액 입력시 true를 반환한다")
    @Test
    void 천원보다_적은_금액_입력시_true를_반환한다() {
        // given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String userInput = "500";

        // when
        boolean result = purchaseAmountValidator.isNotValidPurchaseAmount(userInput);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("천원 단위가 아닌 금액 입력시 true를 반환한다")
    @Test
    void 천원_단위가_아닌_금액_입력시_true를_반환한다() {
        // given
        PurchaseAmountValidator purchaseAmountValidator = new PurchaseAmountValidator();
        String userInput = "1500";

        // when
        boolean result = purchaseAmountValidator.isNotValidPurchaseAmount(userInput);

        // then
        assertThat(result).isTrue();
    }

}