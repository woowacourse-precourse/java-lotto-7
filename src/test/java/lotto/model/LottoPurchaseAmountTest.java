package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {
    @DisplayName("구입 금액에 대한 입력값이 존재하는지 검증")
    @Test
    void 구입_금액에_대한_입력값이_존재하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 숫자인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"1200a", "ab10000", "300a0", "-1000"})
    void 구입_금액이_숫자가_아니면_예외가_발생한다(String amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이 아닌지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"0", "0000", "00000"})
    void 구입_금액이_0이면_예외가_발생한다(String amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000원 단위인지 검증")
    @ParameterizedTest
    @ValueSource(strings = {"12001", "1500", "32050"})
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다(String amount) {
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
