package lotto;

import java.util.List;
import lotto.model.Lottos;
import lotto.service.LottoGenerator;
import lotto.service.strategy.RandomStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator =  new LottoGenerator(new RandomStrategy());
    }

    @Test
    void 로또를_생성한다() {
        Lottos lotto = lottoGenerator.generate(5);
        Assertions.assertThat(lotto).isInstanceOf(Lottos.class);
    }

    @Test
    void 로또_번호를_랜덤으로_생성한다() {
        List<Integer> lottoNumbers = lottoGenerator.createLottoNumber();
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
