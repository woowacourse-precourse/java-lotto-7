package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1", "4", "5", "10", "100"
    })
    @DisplayName("생성된 로또 갯수 일치 여부 테스트")
    void testGenerateLottosSize(int lottoAmount) {
        // Given & When
        List<Lotto> lottos = LottoGenerator.generateLottos(lottoAmount);

        // Then
        assertThat(lottos).hasSize(lottoAmount);
    }
}