package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseTest {
    @DisplayName("수익률 구하기")
    @Test
    void 로또_수익률_구하기() {
        LottoPurchase lottoPurchase = new LottoPurchase(8000);
        assertThat(lottoPurchase.calculateEarnRate(5000)).isEqualTo("62.5");
    }
}
