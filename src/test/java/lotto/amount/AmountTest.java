package lotto.amount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.CustomException;
import lotto.exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @DisplayName("입력한 구입 금액이 로또 가격(1,000원)의 배수라면 예외가 발생하지 않는다.")
    @ValueSource(ints = {1000, 2000, 5000, 10000})
    @ParameterizedTest
    void newAmountWithLottoPurchaseUnitAmount(int validAmount) {
        // when & then
        assertThatCode(() -> new Amount(validAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력한 구입 금액이 로또 가격(1,000원)의 배수가 아니라면 예외가 발생한다.")
    @Test
    void newAmountWithOutLottoPurchaseUnitAmount() {
        // given
        int invalidAmount = 1_001;

        // when & then
        assertThatThrownBy(() -> new Amount(invalidAmount))
                .isInstanceOf(CustomException.class)
                .hasMessage("[ERROR] " + ExceptionMessage.INVALID_LOTTO_AMOUNT_EXCEPTION.getMessage());
    }

    @DisplayName("입력한 구입 금액이 최대 로또 구입 금액을 초과하면 예외가 발생한다.")
    @Test
    void newAmountWithExceedMaxLottoPurchaseAmount() {
        // given
        int exceedAmount = 101_000;

        // when & then
        assertThatThrownBy(() -> new Amount(exceedAmount))
                .isInstanceOf(CustomException.class)
                .hasMessage("[ERROR] " + ExceptionMessage.EXCEED_MAX_LOTTO_AMOUNT_EXCEPTION.getMessage());
    }

    @DisplayName("구매한 로또 갯수는 '구입 금액 / 로또 가격' 이다. ")
    @Test
    void calculatePurchaseLottoCount() {
        // given
        int purchaseAmount = 5_000;
        int lottoPurchaseUnit = 1_000;

        // when
        Amount amount = new Amount(purchaseAmount);
        int lottoCount = amount.calculateLottoCount();

        // then
        assertThat(lottoCount)
                .isEqualTo(purchaseAmount / lottoPurchaseUnit);
    }
}
