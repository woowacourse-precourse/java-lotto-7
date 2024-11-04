package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.validation.LottoPurchaseValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class PurchasedPriceTest {
    @ParameterizedTest
    @ValueSource(longs = {1000, 10000, 100000})
    @DisplayName("올바른 구매 금액 입력")
    void 올바른_구매_금액_입력(long input) {
        // given
        long expectedCount = input / 1000;

        // when
        LottoCount lottoCount = LottoCount.calculatePurchaseCount(input);

        // then
        assertEquals(expectedCount, lottoCount.getCount());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("구매 금액을 입력하지 않았다면 예외가 발생한다.")
    void 구매_금액을_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> LottoPurchaseValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "abcd")
    @DisplayName("구매 금액을 숫자로 입력하지 않았다면 예외가 발생한다.")
    void 구매_금액을_숫자로_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> LottoPurchaseValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2000", "-2500"})
    @DisplayName("구매 금액을 양수로 입력하지 않았다면 예외가 발생한다.")
    void 구매_금액을_양수로_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> LottoPurchaseValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1500", "1234"})
    @DisplayName("구매 금액을 1,000단위로 입력하지 않았다면 예외가 발생한다.")
    void 구매_금액을_1_000_단위로_입력하지_않았다면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> LottoPurchaseValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
