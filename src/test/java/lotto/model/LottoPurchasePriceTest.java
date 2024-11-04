package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("LottoPurchasePrice 모델 테스트")
class LottoPurchasePriceTest {

    @DisplayName("로또 구입금액에 0이 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsZero() {
        // given
        int input = 0;

        // when & then
        assertThatThrownBy(() -> new LottoPurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액이 로또 가격으로 나누어 떨어지지 않으면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenNotDivisibleByLottoPrice() {
        // given
        int input = 2500;

        // when & then
        assertThatThrownBy(() -> new LottoPurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구입금액에 음수가 입력되면 예외를 발생시킨다.")
    @Test
    void throwExceptionWhenInputIsNegative() {
        // given
        int input = -1000;

        // when & then
        assertThatThrownBy(() -> new LottoPurchasePrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}