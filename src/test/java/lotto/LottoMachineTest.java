package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {

    private final LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("로또 금액으로 구매 횟수 구하기")
    @Test
    void getBuyCount() {
        // given
        int price = 12000;

        // when
        int buyCount = lottoMachine.getBuyCount(12000);

        // then
        assertThat(buyCount).isEqualTo(12);
    }
}