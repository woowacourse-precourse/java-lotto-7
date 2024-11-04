package lotto.util.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomLottoGeneratorTest {

    RandomLottoGenerator randomLottoGenerator;

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 원하는_개수만큼_로또가_생성되어야_한다(int count) {
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive,
                    int count) {
                return List.of(1, 2, 3, 4, 5, 6);
            }
        };
        randomLottoGenerator = new RandomLottoGenerator(numberGenerator);

        List<Lotto> lottoList = randomLottoGenerator.generateByCount(count);
        assertThat(lottoList.size()).isEqualTo(count);
    }

}