package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.RandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 15000, 1000000})
    void 구매_금액만큼_로또를_발행할_수_있다(int input) {
        LottoMachine lottoMachine = new LottoMachine(new RandomNumberGenerator());

        List<Lotto> lottoes = lottoMachine.issueLottoes(input);

        assertThat(lottoes).hasSize(input / 1000);
    }

}