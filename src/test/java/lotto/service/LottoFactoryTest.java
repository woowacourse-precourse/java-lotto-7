package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    private LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory();
    }

    @Test
    void 새로운_로또를_생성한다() {
        Lotto lotto = lottoFactory.createLotto();
        assertThat(lotto).isInstanceOf(Lotto.class);
    }


}