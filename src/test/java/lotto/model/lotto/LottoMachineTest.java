package lotto.model.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.lottogenerator.RandomLottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    private final LottoMachine lottoMachine = new LottoMachine(new RandomLottoNumberGenerator());

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5})
    @DisplayName("입력된 개수만큼 로또 생성 테스트")
    void executeLottoMachine(final int input) {
        Lottos lottos = lottoMachine.execute(input);

        assertThat(lottos.getLottos().size()).isEqualTo(input);
    }
}
