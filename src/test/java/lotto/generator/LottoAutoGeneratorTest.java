package lotto.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    static class MockRandomNumberGenerator implements RandomNumberGenerator {
        private final List<Integer> allNumbers;
        private int currentIndex = 0;

        public MockRandomNumberGenerator(List<Integer> allNumbers) {
            this.allNumbers = allNumbers;
        }

        @Override
        public List<Integer> generate(int startInclusive, int endInclusive, int count) {
            if (currentIndex + count > allNumbers.size()) {
                throw new IndexOutOfBoundsException("Not enough numbers to generate.");
            }
            List<Integer> subList = allNumbers.subList(currentIndex, currentIndex + count);
            currentIndex += count;
            return subList;
        }
    }

    @Test
    @DisplayName("성공 - 정확한 개수의 로또 생성")
    void success_generateLottos() {
        // given
        Money money = new Money(3000); // 3장의 로또
        List<Integer> mockNumbers = Arrays.asList(
            1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18
        );
        RandomNumberGenerator mockRandomGenerator = new MockRandomNumberGenerator(mockNumbers);

        LottoAutoGenerator generator = new LottoAutoGenerator(mockRandomGenerator);

        // when
        List<Lotto> lottos = generator.generate(money);

        // then
        assertThat(lottos).hasSize(3);
        assertThat(lottos.get(0).getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottos.get(1).getNumbers()).containsExactly(7, 8, 9, 10, 11, 12);
        assertThat(lottos.get(2).getNumbers()).containsExactly(13, 14, 15, 16, 17, 18);
    }

    @Test
    @DisplayName("성공 - 금액이 0일 때 로또 생성하지 않음")
    void success_generateLottos_zeroMoney() {
        // given
        Money money = new Money(0);
        List<Integer> mockNumbers = Arrays.asList(); // 빈 리스트
        RandomNumberGenerator mockRandomGenerator = new MockRandomNumberGenerator(mockNumbers);

        LottoAutoGenerator generator = new LottoAutoGenerator(mockRandomGenerator);

        // when
        List<Lotto> lottos = generator.generate(money);

        // then
        assertThat(lottos).isEmpty();
    }

    @Test
    @DisplayName("성공 - 금액이 정확히 로또 가격 단위일 때 로또 생성")
    void success_generateLottos_exactMoney() {
        // given
        Money money = new Money(4000); // 4장의 로또
        List<Integer> mockNumbers = Arrays.asList(
            1, 2, 3, 4, 5, 6,
            7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 24
        );
        RandomNumberGenerator mockRandomGenerator = new MockRandomNumberGenerator(mockNumbers);

        LottoAutoGenerator generator = new LottoAutoGenerator(mockRandomGenerator);

        // when
        List<Lotto> lottos = generator.generate(money);

        // then
        assertThat(lottos).hasSize(4);
        assertThat(lottos.get(3).getNumbers()).containsExactly(19, 20, 21, 22, 23, 24);
    }
}
