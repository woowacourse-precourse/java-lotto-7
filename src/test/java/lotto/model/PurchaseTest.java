package lotto.model;

import lotto.exception.InvalidPurchaseAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.ErrorMessage.INVALID_COUNT_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_PRICE_OF_PURCHASE;
import static lotto.exception.ErrorMessage.INVALID_SIZE_OF_PURCHASE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @Test
    @DisplayName("유효한 구입 금액 입력 시 정상적으로 객체를 생성한다.")
    void validPurchasePrice() {
        Purchase purchase = new Purchase(5000);
        assertThat(purchase.getPurchasePrice()).isEqualTo(5000);
    }

    @Test
    @DisplayName("입력된 구입 금액을 반환한다.")
    void getPurchasePrice() {
        Purchase purchase = new Purchase(3000);
        Assertions.assertEquals(purchase.getPurchasePrice(), 3000);
    }

    @Test
    @DisplayName("입력된 구입 금액을 기반으로 구입 로또 개수를 반환한다.")
    void getPurchaseCount() {
        Purchase purchase = new Purchase(10000);
        Assertions.assertEquals(purchase.getPurchaseCount(), 10);
    }

    @Test
    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    void invalidPriceNotMultipleOfOneTicketPrice() {
        assertThatThrownBy(() -> new Purchase(1500))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining(INVALID_PRICE_OF_PURCHASE.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 최대 금액(100,000원)을 초과하는 경우 예외가 발생한다.")
    void invalidPriceExceedsMaxLimit() {
        assertThatThrownBy(() -> new Purchase(150000))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining(INVALID_COUNT_OF_PURCHASE.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 0 이하일 경우 예외가 발생한다.")
    void invalidPriceLessThanOrEqualToZero() {
        assertThatThrownBy(() -> new Purchase(0))
                .isInstanceOf(InvalidPurchaseAmountException.class)
                .hasMessageContaining(INVALID_SIZE_OF_PURCHASE.getMessage());
    }
}
