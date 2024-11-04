package lotto;
import Model.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseTest {

    //로또 구매 테스트
    @DisplayName("구입 금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createPurchaseAmountByNotDivideWith1000() {
        assertThatThrownBy(() -> new LottoPurchase(1500))  // 수정된 부분
                .isInstanceOf(IllegalArgumentException.class);
    }
}