package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {

    @DisplayName("로또 수량을 계산한다.")
    @Test
    void test() {
        int given = 5000;
        int expected = 5;

        int result = LottoPurchase.calculateLottoQuantity(given);
        assertEquals(expected, result);
    }

    @DisplayName("로또 구입할때, 1000원 단위가 아니라면 IllegalArgumentException을 발생시킨다.")
    @Test
    void test1() {
        int given = 5300;

        String expected = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoPurchase.of(given));
        assertEquals(expected, exception.getMessage());
    }

    @DisplayName("로또 구입할때, 1000원 이하라면 IllegalArgumentException을 발생시킨다.")
    @Test
    void test2() {
        int given = 500;

        String expected = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> LottoPurchase.of(given));
        assertEquals(expected, exception.getMessage());
    }

    @DisplayName("로또를 구입할떄, 계산된 금액만큼 로또를 생성한다. ")
    @Test
    void test3() {
        int given = 5000;
        int expected = 5;

        LottoPurchase lottoPurchase = LottoPurchase.of(given);

        assertEquals(expected, lottoPurchase.getLottos().size());
    }
}
