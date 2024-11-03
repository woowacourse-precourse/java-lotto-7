package lotto.domain;

import lotto.constant.LottoErrorMessages;
import lotto.exception.InvalidBuyAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBuyAmountTest {
    @DisplayName("정상 구매 금액이 입력되면 정상 작동한다.")
    @Test
    void 정상_구매_금액_테스트() {
        int amount = 3000;

        LottoBuyAmount lottoBuyAmount = new LottoBuyAmount(amount);

        assertThat(lottoBuyAmount.getLottoBuyCount()).isEqualTo(3);
    }

    @DisplayName("구매 금액이 1,000원으로 나누어 떨어지지 않으면 예외를 발생한다.")
    @Test
    void 나누어_떨어지지_않는_구매_금액_예외_테스트() {
        int amount = 2500;

        assertThatThrownBy(() -> new LottoBuyAmount(amount))
                .isInstanceOf(InvalidBuyAmountException.class)
                .hasMessage(LottoErrorMessages.INVALID_PURCHASE_AMOUNT);
    }

    @DisplayName("구매 금액이 1,000원보다 작으면 예외를 발생한다.")
    @Test
    void 천원_이하의_구매_금액_예외_테스트() {
        int amount = 500;

        assertThatThrownBy(() -> new LottoBuyAmount(amount))
                .isInstanceOf(InvalidBuyAmountException.class)
                .hasMessage(LottoErrorMessages.INVALID_PURCHASE_AMOUNT);
    }
}
