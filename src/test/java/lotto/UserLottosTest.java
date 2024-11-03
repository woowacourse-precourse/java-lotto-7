package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class UserLottosTest {
    @Test
    void 구매금액이_0원이거나_1000원_단위가_아니면_에러가_난다() {
        int purchaseAmount1 = 0;
        assertThatThrownBy(() -> new UserLottos(purchaseAmount1))
                .isExactlyInstanceOf(IllegalArgumentException.class);

        int purchaseAmount2 = 123456;
        assertThatThrownBy(() -> new UserLottos(purchaseAmount2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
