package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.lotto.LottoResult;
import lotto.model.rank.Rank;
import lotto.model.rank.RankResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankCheckerTest {

    @Test
    @DisplayName("주어진 결과에 따라 등급을 확인한다.")
    void checkRankGivenResults() {
        RankChecker rankChecker = new RankChecker();
        LottoResult result1 = new LottoResult(3, false);
        LottoResult result2 = new LottoResult(4, false);
        LottoResult result3 = new LottoResult(5, true);

        List<LottoResult> results = Arrays.asList(result1, result2, result3);

        RankResult rankResult = rankChecker.check(results);
        assertEquals(1, rankResult.getRankCounts().get(Rank.FIFTH));
        assertEquals(1, rankResult.getRankCounts().get(Rank.FOURTH));
        assertEquals(1, rankResult.getRankCounts().get(Rank.SECOND));
    }

}
