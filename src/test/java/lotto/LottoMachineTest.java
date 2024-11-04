package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @DisplayName("로또_머신은_구입금액에_해당하는_수량만큼_로또를_발행할_수_있다")
    @Test
    public void purchaseLottoes() {
        //given
        PurchaseAmount purchaseAmount = PurchaseAmount.of(4000);

        //when
        List<Lotto> result = LottoMachine.purchaseLottoes(purchaseAmount);

        //then
        assertThat(result.size()).isEqualTo(4);
    }
}