package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.strategy.CustomStrategy;
import lotto.model.strategy.RandomStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void beforeEach() {
        lottoGenerator = new LottoGenerator();
    }

    @Test
    void 입력_금액에_맞는_로또가_생성됩니다() {
        List<Lotto> lottos = lottoGenerator.generateLottos(RandomStrategy.of(), PurchaseAmount.from("10000"));
        assertThat(lottos.size()).isEqualTo(10);
    }

    @Test
    void 하나의_로또만_생성됩니다() {
        assertThat(lottoGenerator.generateSingleLotto(RandomStrategy.of())).isInstanceOf(Lotto.class);
    }

    @Test
    void 로또_번호를_램덤으로_뽑아_로또를_생성합니다() {
        RandomStrategy randomStrategy = RandomStrategy.of();
        assertThat(lottoGenerator.generateSingleLotto(randomStrategy)).isInstanceOf(Lotto.class);
    }

    @Test
    void 로또_번호를_수동으로_적어_로또를_생성합니다() {
        CustomStrategy customStrategy = CustomStrategy.of("1,2,3,4,5,6");
        assertThat(lottoGenerator.generateSingleLotto(customStrategy)).isInstanceOf(Lotto.class);
    }

}
