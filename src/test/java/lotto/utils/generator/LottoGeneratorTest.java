package lotto.utils.generator;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    @DisplayName("요청한 개수 생성 검증")
    void givenCount_whenGenerateLottos_thenShouldReturnCorrectCount() {
        // given
        int count = 5;

        // when
        Lottos lottos = LottoGenerator.generateLottos(count);

        // then
        assertThat(lottos.getLottos().size()).isEqualTo(5);
    }
}
