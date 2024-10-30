package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
