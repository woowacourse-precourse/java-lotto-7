package lotto.helper;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsFormatHelperTest {

    private final LottoStatisticsFormatHelper lottoStatisticsFormatHelper;

    LottoStatisticsFormatHelperTest() {
        this.lottoStatisticsFormatHelper = new LottoStatisticsFormatHelper();
    }

    @Test
    @DisplayName("formatPercentRateOfReturn은 소수점 첫 자리가 0이어도 소수점 첫자리까지 포맷팅 된다.")
    void formatPercentRateOfReturn_WithFirstDecimalPlaceIs0_ReturnWithFirstDecimalPlace() {
        // given
        double input = 100.0;

        // when
        String result = lottoStatisticsFormatHelper.formatPercentRateOfReturn(input);

        // then
        assertThat(result).isEqualTo("100.0");
    }

    @Test
    @DisplayName("formatPercentRateOfReturn은 소수점 둘째 자리에서 반올림한 결과를 반환한다.")
    void formatPercentRateOfReturn_ReturnRoundToSecondDecimalPlace() {
        // given
        double input1 = 0.04;
        double input2 = 0.05;

        // when
        String result1 = lottoStatisticsFormatHelper.formatPercentRateOfReturn(input1);
        String result2 = lottoStatisticsFormatHelper.formatPercentRateOfReturn(input2);

        // then
        assertThat(result1).isEqualTo("0.0");
        assertThat(result2).isEqualTo("0.1");
    }

    @Test
    @DisplayName("formatPercentRateOfReturn은 천 단위 구분 기호로 포맷팅 된다.")
    void formatPercentRateOfReturn_ReturnFormattedThousandsSeparator() {
        // given
        double input = 1_000_000.0;

        // when
        String result = lottoStatisticsFormatHelper.formatPercentRateOfReturn(input);

        // then
        assertThat(result).isEqualTo("1,000,000.0");
    }
}
