package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberFormatterTest {

    NumberFormatterWithComma numberFormatter = new NumberFormatterWithComma();

    @Test
    @DisplayName("입력받은 숫자를 천 단위로 콤마 포맷하여 문자열로 반환한다")
    void shouldFormatNumberWithCommas() {
        // given
        int number = 1000;

        // when
        String formattedNumber = numberFormatter.formatNumber(number);

        // then
        assertThat(formattedNumber).isEqualTo("1,000");
    }

    @Test
    @DisplayName("입력받은 숫자를 천 단위로 콤마 포맷하여 문자열로 반환한다")
    void shouldFormatNumberWithCommas2() {
        // given
        int number = 1000000;

        // when
        String formattedNumber = numberFormatter.formatNumber(number);

        // then
        assertThat(formattedNumber).isEqualTo("1,000,000");
    }

    @Test
    @DisplayName("1000 이하의 숫자라면 포맷하지 않은 문자열을 반환한다")
    void doesNotFormatNumberWhenBelowThousand() {
        // given
        int number = 999;

        // when
        String formattedNumber = numberFormatter.formatNumber(number);

        // then
        assertThat(formattedNumber).isEqualTo("999");
    }


}
