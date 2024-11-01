package lotto;

import org.junit.jupiter.api.Test;

/**
 * LottoMachineTest
 */
public class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    void issue_a_valid_lotto() {
        lottoMachine.issue();
    }
}
