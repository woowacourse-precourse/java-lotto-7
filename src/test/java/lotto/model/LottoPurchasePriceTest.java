package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoPurchasePriceTest {

    @Test
    @DisplayName("로또 구입 금액이 1000원 단위가 아니면 예외를 발생시킨다.")
    void validateLottoPurchasePrice() {
        assertThrows(IllegalArgumentException.class, () -> new LottoPurchasePrice(1001));
    }

    @Test
    @DisplayName("로또 구입 금액을 입력하면 몇 개의 로또를 구입할 수 있는지 확인한다.")
    void getPurchaseCount() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(1000);
        assertEquals(1, lottoPurchasePrice.getPurchaseCount());
    }

    @Test
    @DisplayName("입력 받은 로또 구입 금액을 반환한다.")
    void getPurchasePrice() {
        LottoPurchasePrice lottoPurchasePrice = new LottoPurchasePrice(1000);
        assertEquals(1000, lottoPurchasePrice.getPurchasePrice());
    }
}