package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("하나의 로또를 발행한다")
    void publishLotto() {
        //given
        Integer oneCase = 1;

        //when
        Lottos lottos = lottoMachine.publishLottos(oneCase);

        //then
        assertThat(lottos.getQuantity()).isSameAs(1);
    }

    @Test
    @DisplayName("여러건의 로또를 발행한다")
    void publishLottos() {
        //given
        Integer coupleCase = 3;

        //when
        Lottos lottos = lottoMachine.publishLottos(coupleCase);

        //then
        assertThat(lottos.getQuantity()).isSameAs(3);
    }
}