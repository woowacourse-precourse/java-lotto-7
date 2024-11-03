package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    @DisplayName("로또 번호를 6개 생성한다.")
    @Test
    void 로또_번호를_6개_생성한다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.generateLotto();

        assertEquals(6, lotto.getNumbers().size());
    }

    @DisplayName("FixedRandomGenerator를 사용해 로또 번호를 생성한다.")
    @Test
    void 로또_번호_생성한다() {
        RandomGenerator randomGenerator = new FixedRandomGenerator(List.of(1, 2, 3, 4, 5, 6));
        LottoGenerator lottoGenerator = new LottoGenerator(randomGenerator);
        Lotto lotto = lottoGenerator.generateLotto();

        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    static class FixedRandomGenerator implements RandomGenerator {
        private List<Integer> fixedValues;

        public FixedRandomGenerator(List<Integer> fixedValues) {
            this.fixedValues = fixedValues;
        }

        @Override
        public int pickNumberInRange(int start, int end) {
            throw new UnsupportedOperationException("[ERROR] 지원하지 않는 함수입니다.");
        }

        @Override
        public List<Integer> pickUniqueNumbersInRange(int start, int end, int count) {
            return this.fixedValues;
        }
    }
}
