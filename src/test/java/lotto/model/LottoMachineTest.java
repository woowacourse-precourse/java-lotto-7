package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {

    @Test
    @DisplayName("로또 리스트를 입력 개수만큼 생성한다.")
    void generateLotto() {
        LottoMachine lottoMachine = new LottoMachine();
        int lottoCount = 3;

        Lottos lottos = lottoMachine.generateLottos(lottoCount);

        assertThat(lottos.getLottos()).hasSize(lottoCount);
    }

}