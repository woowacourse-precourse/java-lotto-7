package lotto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import lotto.model.LottoBuy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.math.BigInteger;


class LottoBuyTest {
    @DisplayName("금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBuy(BigInteger.valueOf(1500)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @DisplayName("금액이 0원 이하이면 예외가 발생한다.")
    @Test
    void 금액이_0원_이하이면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBuy(BigInteger.valueOf(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }


    @DisplayName("로또 개수가 올바르게 계산된다.")
    @Test
    void 로또_개수가_올바르게_계산된다() {
        LottoBuy purchase = new LottoBuy(BigInteger.valueOf(5000));
        assertThat(purchase.getNumberOfLottos()).isEqualTo(BigInteger.valueOf(5));
    }
}
