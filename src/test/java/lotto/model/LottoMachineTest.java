package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    void 로또_하나_생성() {
        //when
        Lotto lotto = lottoMachine.buyLotto();
        //then
        assertThat(lotto).isInstanceOf(Lotto.class);
    }
}