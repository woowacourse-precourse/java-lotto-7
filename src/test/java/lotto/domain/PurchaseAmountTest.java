package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("금액에 해당하는만큼 로또를 발행한다 - 1000원마다 1장 발행")
    @Test
    void issueLottos() {
        //given
        int amount = 8000;
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        //when
        int countOfLottos = purchaseAmount.calculateNumberOfLottos();

        //then
        assertThat(countOfLottos).isEqualTo(8);
    }

}