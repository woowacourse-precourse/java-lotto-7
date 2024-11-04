package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("구입 금액에 따른 로또 개수가 올바르게 생성된다")
    void generateLottos() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.generateLottos(5000);
        assertThat(lottos).hasSize(5);
    }
}