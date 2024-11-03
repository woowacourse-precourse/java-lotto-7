package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;
class LottoPurchaseTest {

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    void 올바른_구입_금액_테스트() {
        provideInput("5000\n");
        LottoPurchase lottoPurchase = new LottoPurchase();
        int amount = lottoPurchase.getPurchaseAmount();
        assertThat(amount).isEqualTo(5000);
    }

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        assertThatThrownBy(() -> lottoPurchase.validateAmount(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외() {
        LottoPurchase lottoPurchase = new LottoPurchase();
        assertThatThrownBy(() -> {
            int amount = Integer.parseInt("abc");
            lottoPurchase.validateAmount(amount);
        }).isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string: \"abc\"");
    }
}