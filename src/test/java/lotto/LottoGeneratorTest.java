package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.service.LottoGenerator;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void generateByRandom_shouldReturnValidLotto() {
        Lotto lotto = lottoGenerator.generateByRandom();
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(6);
        assertThat(lotto.getNumbers()).allMatch(num -> num >= 1 && num <= 45);
    }
}
