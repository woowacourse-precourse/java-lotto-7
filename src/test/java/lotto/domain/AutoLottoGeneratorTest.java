package lotto.domain;

import lotto.domain.vo.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class AutoLottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new AutoLottoGenerator();
    }

    @Test
    void 로또를_지정한_개수만큼_자동으로_생성한다() {
        // given
        int count = 5;

        // when
        List<Lotto> lottos = lottoGenerator.generate(count);

        // then
        assertThat(lottos).hasSize(count);
    }

    @Test
    void 생성된_로또_번호들이_지정된_범위_내에_포함된다() {
        // given
        int count = 1;

        // when
        List<Lotto> lottos = lottoGenerator.generate(count);

        // then
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers())
                    .allMatch(number -> number.lottoNumber() >= 1 && number.lottoNumber() <= 45);
        }
    }

    @Test
    void 생성된_로또_번호들이_중복되지_않는다() {
        // given
        int count = 1;

        // when
        List<Lotto> lottos = lottoGenerator.generate(count);

        // then
        for (Lotto lotto : lottos) {
            long uniqueCount = lotto.getNumbers().stream()
                    .map(Number::lottoNumber)
                    .distinct()
                    .count();
            assertThat(uniqueCount).isEqualTo(6);
        }
    }
}
