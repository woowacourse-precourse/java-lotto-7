package lotto;

import lotto.domain.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PurchaseTest {

    @DisplayName("구매 금액이 1000원 단위로 나누어 떨어지지 않으면 예외를 호출한다.")
    @Test
    void 구매_금액이_1000원_단위로_나누어_떨어지지_않으면_예외를_호출한다() {
        assertThatThrownBy(() -> new LottoPurchase(1001))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
