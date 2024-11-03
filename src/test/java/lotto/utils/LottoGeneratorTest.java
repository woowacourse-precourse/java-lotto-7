package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
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
    void 로또_생성_갯수_일치_테스트(int lottoAmount) {
        // Given & When
        LottoTickets lottos = LottoGenerator.generateLottoTickets(BigDecimal.valueOf(lottoAmount));

        // Then
        assertThat(lottos.getLottoCount()).isEqualTo(lottoAmount);
    }
}