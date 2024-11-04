package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoFactoryTest {
    LottoFactory lottoFactory;

    @BeforeEach
    void setUp() {
        lottoFactory = LottoFactory.getInstance();
    }

    @Test
    void 로또_발급_테스트() {
        //given,when
        Lotto lotto = lottoFactory.createLotto();

        //then
        assertThat(lotto).isNotNull();
        assertThat(lotto.getNumbers())
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch(num -> num >= 1 && num <= 45);
    }

}
