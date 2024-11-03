package lotto.validator;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchasePriceValidatorTest {

    @Test
    @DisplayName("로또 구매 금액이 1000보다 작은 경우 예외를 발생시키고 관련 예외 메시지를 출력한다")
    void shouldThrowExceptionWhenLottoPurchaseAmountIsLessThan1000() {
        // given
        int price = 100;

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> LottoPurchasePriceValidator.validateLottoPurchasePrice(price))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.UNDER_MINIMUM_PURCHASE_AMOUNT.getMessage())
        );
    }

    //feat(LottoPurchasePriceValidator): Add class to validate price
    //- Validate purchase price of lotto
    @Test
    @DisplayName("로또 구매 금액이 10만원보다 큰 경우 예외를 발생시키고 관련 예외 메시지를 출력한다")
    void shouldThrowExceptionWhenLottoPurchaseAmountIsMoreThan100_000() {
        // given
        int price = 1_000_000;

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> LottoPurchasePriceValidator.validateLottoPurchasePrice(price))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.EXCEED_MAXIMUM_PURCHASE_AMOUNT.getMessage())
        );
    }

    @Test
    @DisplayName("로또 구매 금액이 1000원 단위가 아닌 경우")
    void shouldThrowExceptionWhenLottoPurchaseAmountIsNotInThousandWon() {
        // given
        int price = 1999;

        // when & then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> LottoPurchasePriceValidator.validateLottoPurchasePrice(price))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LottoException.INVALID_PURCHASE_PRICE.getMessage())
        );
    }
}
