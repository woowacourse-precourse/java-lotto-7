package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBuyValidatorTest {

    private final LottoBuyValidator lottoBuyValidator;

    LottoBuyValidatorTest() {
        this.lottoBuyValidator = new LottoBuyValidator();
    }

    @Test
    @DisplayName("validateMoneyAmount는 로또 가격으로 나눠지지 않는 금액이 들어올 경우, IllegalArgumentException을 던진다.")
    void validateMoneyAmount_WithNonPositive_ThrowIllegalArgumentException() {
        // given
        int nonPositive = 0;

        // when & then
        assertThatThrownBy(
                () -> lottoBuyValidator.validateMoneyAmount(nonPositive)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateMoneyAmount는 로또 가격으로 나눠지지 않는 금액이 들어올 경우, IllegalArgumentException을 던진다.")
    void validateMoneyAmount_WithNonDivisibleLottoPrice_ThrowIllegalArgumentException() {
        if (Lotto.PRICE == 1) {
            return;
        }

        // given
        int nonDivisibleLottoPrice = Lotto.PRICE + 1;

        // when & then
        assertThatThrownBy(
                () -> lottoBuyValidator.validateMoneyAmount(nonDivisibleLottoPrice)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("validateMoneyAmount는 유효한 금액이 들어올 경우, 예외를 던지지 않는다.")
    void validateMoneyAmount_WithValidPrice_ThrowIllegalArgumentException() {
        // given
        int validPrice = Lotto.PRICE * 2;

        // when & then
        assertThatCode(
                () -> lottoBuyValidator.validateMoneyAmount(validPrice)
        ).doesNotThrowAnyException();
    }
}
