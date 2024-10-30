package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @Test
    void 난수_생성_확인() {
        IntStream.range(1, 100 + 1).forEach(i -> {
            // given
            RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

            // when
            Lotto randomLotto = randomLottoGenerator.generate();

            // then
            assertThat(randomLotto.getNumbers()).hasSize(6);
            assertThat(randomLotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);

            System.out.printf("횟수: %d, 결과: %s%n", i, randomLotto.getNumbers());
        });
    }
}