package lotto;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void 해당_수량만큼_로또를_발행하는지_테스트() {
        assertSimpleTest(() -> {
            // given
            LottoGenerator lottoGenerator = new LottoGenerator();
            int quantity = 3;

            // when
            Lottos lottos = lottoGenerator.issue(quantity);

            // then
            assertThat(lottos.size()).isEqualTo(quantity);
        });
    }
}
