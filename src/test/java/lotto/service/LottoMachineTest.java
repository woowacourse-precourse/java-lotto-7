package lotto.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import lotto.domain.Lotto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    void 로또_티켓_발급(){
        int count = 6;
        LottoMachine machine = new LottoMachine(count);

        // when
        List<Lotto> lottos = machine.getLottos();

        // then
        assertThat(lottos).hasSize(count);
    }


}

