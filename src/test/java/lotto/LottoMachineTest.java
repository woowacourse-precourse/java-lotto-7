package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 구매_금액이_로또_가격으로_나누어지지_않으면_예외발생() {
        LottoMachine lottoMachine = new LottoMachine();
        int invalidAmount = 1500;

        assertThrows(IllegalArgumentException.class, () -> {
            lottoMachine.buyLotto(invalidAmount);
        });
    }

    @Test
    void 구매_금액에_맞게_정상적으로_로또가_구매되는지_확인() {
        LottoMachine lottoMachine = new LottoMachine();
        int purchaseAmount = 5000;

        List<Lotto> lottos = lottoMachine.buyLotto(purchaseAmount);
        assertEquals(5, lottos.size());
    }
}
