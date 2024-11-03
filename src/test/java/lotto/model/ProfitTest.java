package lotto.model;

import static lotto.enums.LottoWinInfo.FIFTH;
import static lotto.enums.LottoWinInfo.FIRST;
import static lotto.enums.LottoWinInfo.FOURTH;
import static lotto.enums.LottoWinInfo.SECOND;
import static lotto.enums.LottoWinInfo.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import lotto.enums.LottoWinInfo;
import lotto.model.result.Profit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitTest {
    EnumMap<LottoWinInfo, Integer> lottoWinCount = new EnumMap<>(LottoWinInfo.class);

    @BeforeEach
    void setUp() {
        lottoWinCount.put(FIRST, 0);
        lottoWinCount.put(SECOND, 0);
        lottoWinCount.put(THIRD, 0);
        lottoWinCount.put(FOURTH, 0);
        lottoWinCount.put(FIFTH, 0);
    }

    @Test
    void 수익률계산_0원_테스트() {
        // given
        int payment = 8000;

        // when
        Profit profit = new Profit(lottoWinCount, payment);

        // then
        assertThat(profit.getProfit()).isEqualTo(0);
    }

    @Test
    void 수익률계산_우테코예시_테스트() {
        // given
        int payment = 8000;
        lottoWinCount.put(FIFTH, 1);

        // when
        Profit profit = new Profit(lottoWinCount, payment);

        // then
        assertThat(profit.getProfit()).isEqualTo(62.5);
    }

    @Test
    void 수익률계산_여러개당첨_테스트() {
        // given
        int payment = 10000;
        lottoWinCount.put(FOURTH, 2);

        // when
        Profit profit = new Profit(lottoWinCount, payment);

        // then
        assertThat(profit.getProfit()).isEqualTo(1000);
    }
}
