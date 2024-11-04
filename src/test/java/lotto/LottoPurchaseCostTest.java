package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.LottoPurchaseCost;
import org.junit.jupiter.api.Test;

public class LottoPurchaseCostTest {
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseCost.of("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_양수가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseCost.of("-1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseCost.of("o.o"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입_금액이_자료형_범위를_벗어나면_아니면_예외를_발생한다() {
        assertThatThrownBy(() -> LottoPurchaseCost.of("2147483648"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
