package lotto.constants;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMessageTest {

    @Test
    void int_값을_넣으면_문자열에_포함해서_반환() {
        // given
        int count = 5;

        // when
        String result = ResultMessage.PURCHASED_LOTTO.getIntMessage(count);

        // then
        assertThat(result).isEqualTo("5개를 구매했습니다.");
    }

    @Test
    void double_값을_넣으면_문자열에_포함해서_반환() {
        // given
        double rate = 62.5;

        // when
        String result = ResultMessage.TOTAL_PROFIT_RATE.getProfitRateMessage(rate);

        // then
        assertThat(result).isEqualTo("총 수익률은 62.5%입니다.");
    }
}