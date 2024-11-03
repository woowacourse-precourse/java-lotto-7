package lotto.common;

import lotto.common.factory.LottoFactory;
import lotto.domain.Lottos;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 주문한_사이즈만큼_로또를_구매한다(int orderSize) {
        //given
        Lottos lottos = LottoFactory.sizeFrom(orderSize);

        // when & then
        assertThat(lottos.getLottos().size()).isEqualTo(orderSize);
    }

}