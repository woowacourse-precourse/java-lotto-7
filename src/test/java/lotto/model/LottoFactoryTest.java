package lotto.model;

import lotto.domain.Lottos;
import lotto.model.random.FixedNumberGenerator;
import lotto.model.random.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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