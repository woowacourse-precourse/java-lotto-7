package lotto.global.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.winningNumber.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MessageFormatterTest {

    @Test
    @DisplayName("당첨결과를 받아 당첨 통계를 String으로 반환한다")
    void getLotteryResults() throws Exception {
        // given
        Map<LottoResult, Integer> lottoResult = getLottoResult(0);

        // when
        String lotteryResults = MessageFormatter.getLotteryResults(lottoResult);

        // then
        assertThat(lotteryResults).isEqualTo("3개 일치 (5,000원) - 0개\n"
                + "4개 일치 (50,000원) - 0개\n"
                + "5개 일치 (1,500,000원) - 0개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n"
                + "6개 일치 (2,000,000,000원) - 0개\n");
    }

    @Test
    @DisplayName("당첨결과를 받아 수익률을 반환한다")
    void getReturnRate() throws Exception {
        // given
        int amount = 1000;
        Map<LottoResult, Integer> lottoResult = getLottoResult(1);

        // when
        String returnRate = MessageFormatter.getReturnRate(lottoResult, amount);

        // then
        assertThat(returnRate).isEqualTo("203155500.0%");

    }

    private static Map<LottoResult, Integer> getLottoResult(int count) {
        HashMap<LottoResult, Integer> lottoResult = new HashMap<>();
        for (LottoResult value : LottoResult.values()) {
            lottoResult.put(value, count);
        }
        return lottoResult;
    }

}