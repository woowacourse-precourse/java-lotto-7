package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -32})
    void 로또_구매가격이_0이하이면_예외를_반환한다(Integer amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoPurchase(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 14237, 784132, 98745, 1410})
    void 금액이_1000원으로_떨어지지_않으면_예외를_반환한다(int amount) {
        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LottoPurchase(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 10000})
    void 로또_구매를_성공한다(Integer amount) {
        // when, then
        Assertions.assertDoesNotThrow(() -> {
            new LottoPurchase(amount);
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000, 4000, 10000})
    void 구매_개수는_amount_를_1000으로_나눈것과_같다(Integer amount) {
        // when
        LottoPurchase lottoPurchase = new LottoPurchase(amount);

        // then
        assertThat(lottoPurchase.getCount()).isEqualTo(amount / 1000);
    }
}
