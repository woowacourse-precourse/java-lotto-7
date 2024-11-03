package lotto.domain.lottos.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;
import lotto.domain.calculators.FinalPrizeCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    private WinningRank winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningRank(new FinalPrizeCalculator());
    }

    @Test
    void 매칭_결과_랭크_업데이트_확인() {
        EnumMap<Rank, Integer> expected = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            expected.put(rank, 0);
        }
        expected.merge(Rank.FIRST, 1, Integer::sum);
        expected.merge(Rank.FIRST, 1, Integer::sum);
        expected.merge(Rank.SECOND, 1, Integer::sum);

        List<Rank> matchedResults = new ArrayList<>();
        matchedResults.add(Rank.FIRST);
        matchedResults.add(Rank.FIRST);
        matchedResults.add(Rank.SECOND);

        winningLotto.addAllMatchedRank(matchedResults);
        EnumMap<Rank, Integer> actual = winningLotto.getWinningStatistics();

        assertEquals(expected, actual);
    }

}