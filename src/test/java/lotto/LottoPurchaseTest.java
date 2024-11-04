package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoPurchaseTest {

    @Test
    @DisplayName("구매 금액이 1000원 단위가 아닐 경우 예외 발생")
    public void testPurchaseAmountNotMultipleOfThousand() {
        LottoPurchase lottoPurchase = new LottoPurchase();

        assertThatThrownBy(() -> {
            lottoPurchase.inputPurchaseAmount("2500");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("정상적인 구매 금액 입력")
    public void testValidPurchaseAmount() {
        LottoPurchase lottoPurchase = new LottoPurchase();

        assertThat(lottoPurchase.inputPurchaseAmount("5000")).isEqualTo(5000);
    }
}
