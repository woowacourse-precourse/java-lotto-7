package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoFactoryTest {
    private LottoFactory lottoFactory;
    @BeforeEach
    void setUp() {
        lottoFactory = new LottoFactory(new MockLottoNumberGenerator());
    }

    @Test
    void LottoGenerator에서_만든_번호로_로또_객체가_만들어지면_성공한다() {
        //given
        //when
        List<Lotto> lottos = lottoFactory.createAllLottos(3);
        //then
        Assertions.assertThat(lottos.size()).isEqualTo(3);
        Assertions.assertThat(lottos)
                .isInstanceOf(List.class)
                .isNotEmpty()
                .allMatch(lotto -> lotto instanceof Lotto);

    }

    private static class MockLottoNumberGenerator extends LottoNumberGenerator {
        @Override
        public List<Integer> createLottoNumbers(int start, int end, int count) {
            return List.of(1, 3, 5, 7, 9, 11);
        }
    }
}
