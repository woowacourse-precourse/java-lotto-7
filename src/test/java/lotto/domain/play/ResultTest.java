package lotto.domain.play;

import lotto.domain.rule.PrizeRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @DisplayName("등수에 따른 수익을 계산하는지 확인")
    @Test
    void testCalculateTotalProfit() {
        Map<PrizeRank, Integer> prizeRankCounts = generatePrizeRankCounts(1,1,1,1,1,1);
        Result result = new Result(prizeRankCounts);
        int expected = 2031555000;
        int actual = result.calculateTotalProfit();

        assertThat(actual).isEqualTo(expected);
    }

    private static Map<PrizeRank, Integer> generatePrizeRankCounts(int first, int second, int third, int fourth, int fifth, int lose) {
        Map<PrizeRank, Integer> prizeRanks = new EnumMap<>(PrizeRank.class);
        prizeRanks.put(PrizeRank.FIRST, first);
        prizeRanks.put(PrizeRank.SECOND, second);
        prizeRanks.put(PrizeRank.THIRD, third);
        prizeRanks.put(PrizeRank.FOURTH, fourth);
        prizeRanks.put(PrizeRank.FIFTH, fifth);
        prizeRanks.put(PrizeRank.LOSE, lose);
        return prizeRanks;
    }
}