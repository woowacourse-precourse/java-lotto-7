package lotto.domain.lottos.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.LottoMatchedResult;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    final WinningLotto winningLotto = new WinningLotto();

    @Test
    void 매칭_결과_랭크_업데이트_확인() {
        EnumMap<Rank, Integer> expected = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            expected.put(rank, 0);
        }
        expected.merge(Rank.FIRST, 1, Integer::sum);
        expected.merge(Rank.FIRST, 1, Integer::sum);
        expected.merge(Rank.SECOND, 1, Integer::sum);

        List<LottoMatchedResult> matchedResults = new ArrayList<>();
        matchedResults.add(new LottoMatchedResult(6, true));
        matchedResults.add(new LottoMatchedResult(6, false));
        matchedResults.add(new LottoMatchedResult(5, true));

        winningLotto.addMatchedResultAsRank(matchedResults);
        EnumMap<Rank, Integer> actual = winningLotto.getWinningStatistics();

        assertEquals(expected, actual);
    }
}