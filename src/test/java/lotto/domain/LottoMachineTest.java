package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.strategy.NumberGenerationStrategy;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 로또를_발행한다() {
        //given
        LottoMachine lottoMachine = new LottoMachine();
        NumberGenerationStrategy numberGenerationStrategy = (min, max, size) -> List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = lottoMachine.issueLotto(numberGenerationStrategy);

        //then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }
}