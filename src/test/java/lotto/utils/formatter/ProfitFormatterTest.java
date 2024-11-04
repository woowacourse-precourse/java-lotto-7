package lotto.utils.formatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitFormatterTest {

    @ParameterizedTest
    @DisplayName("수익률이 1000단위 콤마와 소수 첫째 자리까지 표시되고, % 기호가 포함되어 있는지 검증")
    @CsvSource({
            "1250000.5, '1,250,000.5%'",
            "1234.6, '1,234.6%'"
    })
    void 수익률_포맷_검증(BigDecimal profitRate, String expected) {
        String formattedProfitRate = ProfitFormatter.formatProfitRate(profitRate);
        assertThat(formattedProfitRate).isEqualTo(expected);
    }
}
