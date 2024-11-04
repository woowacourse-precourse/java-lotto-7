package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import lotto.constant.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchasePriceTest {
    @Test
    @DisplayName("입력값을 가진 객체가 생성된다.")
    void testCreatePurchasePriceIfValueIsValid() {
        int value = 1000;
        PurchasePrice purchasePrice = new PurchasePrice(value);
        assertThat(purchasePrice.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("양의 정수가 아닌 값을 입력하면 예외가 발생한다.")
    void testThrowExceptionIfValueIsNotPositive(int value) {
        assertThatThrownBy(() -> new PurchasePrice(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.PURCHASE_PRICE_NON_POSITIVE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 판매 단위가 아닌 값을 입력하면 예외가 발생한다.")
    void testThrowExceptionIfValueIsNotUnitOfPurchase() {
        int invalidValue = Rule.LOTTO_PRICE * 2 + 100;
        assertThatThrownBy(() -> new PurchasePrice(invalidValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.PURCHASE_PRICE_INVALID_AMOUNT_UNIT.getMessage());
    }
}
