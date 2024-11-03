package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPurchaseTest {

    @DisplayName("입력한 금액에 맞춰 티켓이 생성되는지 테스트")
    @Test
    void lottoTicketsGenerateTest() {
        LottoPurchase lottoPurchase = new LottoPurchase(3000);
        Assertions.assertThat(lottoPurchase.getLottoPurchaseResult().lottoTicketsNumbers().size()).isEqualTo(3);
    }
}
