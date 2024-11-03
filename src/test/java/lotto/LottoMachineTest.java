package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void 로또_생성_테스트(){
        int quantity = 5;

        List<Lotto> lottos = lottoMachine.createLotto(quantity);

        Assertions.assertThat(lottos.size()).isEqualTo(quantity);
    }
}