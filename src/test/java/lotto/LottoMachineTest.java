package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    void 투입금액_만큼_로또를_발행한다() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThat(lottoMachine.issueLottosWith(new Money(8000))).hasSize(8);
    }

    @Test
    void 잔돈이_생기면_예외를_발생시킨다() {
        LottoMachine lottoMachine = new LottoMachine();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoMachine.issueLottosWith(new Money(8102)));
    }
}
