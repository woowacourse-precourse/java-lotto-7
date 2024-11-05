package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseAmountTest {
    @Test
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액을 1000원 단위로 나누어 로또 개수를 반환한다.")
    void 구입_금액으로_로또_개수를_반환한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        assertThat(purchaseAmount.getLottoCount()).isEqualTo(8);
    }
}
