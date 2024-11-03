package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PriceFormatterTest {
    @Test
    void 가격을_한국식_표기법으로_변환() {
        // given
        int price = 1000000;

        // when
        String actual = PriceFormatter.formatToKoreanStyle(price);
        String expected = "1,000,000";

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
