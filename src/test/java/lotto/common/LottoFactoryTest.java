package lotto.common;

import lotto.common.factory.LottoFactory;
import lotto.domain.Lottos;
import lotto.common.random.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {
    LottoFactory lottoFactory;

    @Test
    void 주문한_사이즈만큼_로또를_구매한다() {
        //given
        lottoFactory = new LottoFactory(new RandomNumberGenerator());
        Lottos lottos = lottoFactory.sizeFrom(5);

        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }

}