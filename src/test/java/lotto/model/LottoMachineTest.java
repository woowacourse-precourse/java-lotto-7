package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.utils.LottoNumberGeneratorStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    private LottoMachine lottoMachine;
    private LottoNumberGeneratorStrategy strategy;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
        strategy = new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generate() {
                return List.of(1, 2, 3, 4, 5, 6); // 고정된 숫자 생성
            }
        };
    }

    @Test
    void 로또_티켓_생성_금액에_따라_티켓_수_올바른_생성() {
        // given
        int purchaseAmount = 1000;

        // when
        Lottos generatedLottos = lottoMachine.generateLottos(purchaseAmount, strategy);

        // then
        assertThat(generatedLottos.size()).isEqualTo(1);
        generatedLottos.getLottos().forEach(lotto ->
                assertThat(lotto.getNumbers()).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
        );
    }
}
