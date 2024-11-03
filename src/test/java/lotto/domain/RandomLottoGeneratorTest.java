package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLottoGeneratorTest {

    @Test
    @DisplayName("랜덤으로 6개 숫자를 뽑아 Lotto를 만든다.")
    void generate() {
        // given
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

        // when
        Lotto lotto = randomLottoGenerator.generate();

        // then
        assertThat(lotto).isNotNull();
    }
}