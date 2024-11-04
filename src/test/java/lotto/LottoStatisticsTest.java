package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LottoStatisticsTest {
    @Test
    @DisplayName("개수 세기")
    void count() {
        List<Optional<LottoResult>> results = List.of(
            Optional.empty(), Optional.empty(),
            Optional.of(LottoResult.FIFTH), Optional.of(LottoResult.FOURTH),
            Optional.of(LottoResult.FOURTH)
        );
        Map<LottoResult, Integer> count = LottoStatistics.countResult(results);
        Assertions.assertEquals(1, count.get(LottoResult.FIFTH));
        Assertions.assertEquals(2, count.get(LottoResult.FOURTH));
        Assertions.assertEquals(0, count.get(LottoResult.THIRD));
        Assertions.assertEquals(0, count.get(LottoResult.SECOND));
        Assertions.assertEquals(0, count.get(LottoResult.FIRST));
    }

    @Test
    @DisplayName("수익률 구하기")
    void getRateOfReturn() {
        List<Optional<LottoResult>> results = List.of(
                Optional.empty(), Optional.empty(),
                Optional.of(LottoResult.FIFTH), Optional.of(LottoResult.FOURTH),
                Optional.of(LottoResult.FOURTH)
        );
        double rateOfReturn = LottoStatistics.getRateOfReturn(results);
        int expectWinningPay = LottoResult.FIFTH.getWinningMoney() + LottoResult.FOURTH.getWinningMoney() * 2;
        Assertions.assertEquals((double)expectWinningPay / 5000, rateOfReturn);
    }
}
