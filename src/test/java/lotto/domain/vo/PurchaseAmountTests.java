package lotto.domain.vo;

import static lotto.domain.constants.LottoConstants.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.*;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTests {
    @ParameterizedTest
    @ValueSource(ints = {LOTTO_PRICE, LOTTO_PRICE * 5, LOTTO_PRICE * 10})
    void testValidPurchaseAmountCalculatesLottoCountCorrectly(int amount) {
        PurchaseAmount purchaseAmount = PurchaseAmount.of(amount);

        int lottoCount = purchaseAmount.calculateLottoCount();

        assertThat(lottoCount).isEqualTo(amount / LOTTO_PRICE);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -100, -1000, LOTTO_PRICE - 100, LOTTO_PRICE - 1})
    void testInsufficientAmountThrowsException(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_INSUFFICIENT.getLottoPriceIncludeMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {LOTTO_PRICE + 700, LOTTO_PRICE * 2 + 400})    void testNonMultipleAmountThrowsException(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.MONEY_LEFT.getLottoPriceIncludeMessage());
    }

    @Test
    void testGetAmountReturnsCorrectValue() {
        int amount = LOTTO_PRICE * 3;
        PurchaseAmount purchaseAmount = PurchaseAmount.of(amount);

        assertThat(purchaseAmount.getAmount()).isEqualTo(amount);
    }
}