package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class UserLottosTest {
    @Test
    void 구매금액이_0원이거나_1000원_단위가_아니면_에러가_난다() {
        int purchaseAmount1 = 0;
        assertThatThrownBy(() -> new UserLottos(purchaseAmount1))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        int purchaseAmount2 = -123456;
        assertThatThrownBy(() -> new UserLottos(purchaseAmount2))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        int purchaseAmount3 = 123456;
        assertThatThrownBy(() -> new UserLottos(purchaseAmount3))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액에_맞는_수량을_구한다() {
        int purchaseAmount = 14000;
        assertThat(new UserLottos(purchaseAmount).getQuantity())
                .isEqualTo(14);
    }

    @Test
    void 수량에_맞게_로또를_생성한다() {
        int purchaseAmount = 124000;
        assertThat(new UserLottos(purchaseAmount).getLottos().size())
                .isEqualTo(124);
    }
}
