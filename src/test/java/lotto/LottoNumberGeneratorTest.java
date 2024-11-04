package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("로또 번호를 올바르게 생성한다.")
    void generateLottoNumbers() {
        // Given
        int lottoAmount = 5;
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // When
        List<Lotto> lottos = generator.generate(lottoAmount);

        // Then
        assertThat(lottos).hasSize(5);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
            assertThat(lotto.getNumbers()).doesNotHaveDuplicates();
            assertThat(lotto.getNumbers()).allMatch(number -> number >= 1 && number <= 45);
        }
    }
}
