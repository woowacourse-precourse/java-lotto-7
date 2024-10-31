package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoResults;
import lotto.model.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    private LottoResults results;
    private Lotto winningLotto;
    private int bonusNumber;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
    }

    @Test
    void 초기화된_resultMap이_모든_Rank에_대해_0으로_설정되어야_한다() {
        results = new LottoResults(List.of(), winningLotto, bonusNumber);

        Map<Rank, Integer> expected = new HashMap<>();
        for (Rank rank : Rank.values()) {
            expected.put(rank, 0);
        }

        assertEquals(expected, results.getResultMap());
    }

    @Test
    void calculateResult는_구매한_로또의_당첨_결과를_정확히_계산해야_한다() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 6개 일치 (1등)
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 5개 + 보너스 일치 (2등)
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 5개 일치 (3등)
                new Lotto(List.of(1, 2, 3, 4, 9, 10)), // 4개 일치 (4등)
                new Lotto(List.of(1, 2, 3, 11, 12, 13)) // 3개 일치 (5등)
        );

        results = new LottoResults(userLottos, winningLotto, bonusNumber);
        results.calculateResult();

        Map<Rank, Integer> expectedResults = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 1,
                Rank.FOURTH, 1,
                Rank.FIFTH, 1,
                Rank.MISS, 0
        );

        assertEquals(expectedResults, results.getResultMap());
    }

    @Test
    void getResultMap_메서드는_계산된_당첨_결과를_정확히_반환해야_한다() {
        results = new LottoResults(List.of(), winningLotto, bonusNumber);
        results.calculateResult();

        Map<Rank, Integer> resultMap = results.getResultMap();
        for (Rank rank : Rank.values()) {
            assertEquals(0, resultMap.get(rank));
        }
    }
}
