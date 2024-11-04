package lotto.lotto.service;

import java.util.List;
import lotto.common.util.random.LottoRandomGenerator;
import lotto.common.util.random.RandomGenerator;
import lotto.lotto.domain.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {

    private RandomGenerator randomGenerator;
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        randomGenerator = new LottoRandomGenerator();
        lottoFactory = new LottoFactory(randomGenerator);
    }

    @Test
    @DisplayName("수량에 맞는 로또를 랜덤으로 생성한다")
    void generateMultipleLottosTest() {
        // given
        long count = 5;

        // when
        List<LottoResult> lottoResults = lottoFactory.generateMultipleLottos(count);

        // then
        Assertions.assertThat(lottoResults).hasSize((int) count);
        Assertions.assertThat(lottoResults.getFirst()).isInstanceOf(LottoResult.class);
    }
}