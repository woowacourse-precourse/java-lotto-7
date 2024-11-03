package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.DisplayName;
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
        LottoTickets lottos = LottoGenerator.generateLottoTickets(lottoAmount);

        // Then
        assertThat(lottos.getLottoCount()).isEqualTo(lottoAmount);
    }
}