package lotto;

import lotto.domain.lottoMatchChecker.DefaultLottoMatchChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import lotto.dto.entity.Lotto;
import lotto.dto.entity.WinningLotto;
import lotto.utils.LottoMatchStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultLottoMatchCheckerTest {
    private DefaultLottoMatchChecker lottoMatchChecker;

    @BeforeEach
    void setUp() {
        lottoMatchChecker = new DefaultLottoMatchChecker();
    }

    @Test
    void 로또_일치_테스트() {
        // Given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 5개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)), // 4개 일치
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), // 3개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))  // 5개 일치, 보너스 일치
        );

        // When
        HashMap<LottoMatchStatus, Integer> result = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        // Then
        assertEquals(1, result.get(LottoMatchStatus.THREE_MATCH_RESULT) != null ? result.get(LottoMatchStatus.THREE_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.FOUR_MATCH_RESULT) != null ? result.get(LottoMatchStatus.FOUR_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.FIVE_MATCH_RESULT) != null ? result.get(LottoMatchStatus.FIVE_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.SIX_MATCH_RESULT) != null ? result.get(LottoMatchStatus.SIX_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT) != null ? result.get(LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT) : 0);
    }

    @Test
    void 로또_일치_테스트2() {
        // Given
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 10, 13, 14, 15, 18)), // 1개 일치
                new Lotto(Arrays.asList(1, 2, 13, 14, 17, 18)), // 2개 일치
                new Lotto(Arrays.asList(1, 2, 3, 18, 19, 10)), // 3개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 5개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7))  // 5개 일치, 보너스 일치
        );

        // When
        HashMap<LottoMatchStatus, Integer> result = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        // Then
        assertEquals(1, result.get(LottoMatchStatus.THREE_MATCH_RESULT) != null ? result.get(LottoMatchStatus.THREE_MATCH_RESULT) : 0);
        assertEquals(0, result.get(LottoMatchStatus.FOUR_MATCH_RESULT) != null ? result.get(LottoMatchStatus.FOUR_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.FIVE_MATCH_RESULT) != null ? result.get(LottoMatchStatus.FIVE_MATCH_RESULT) : 0);
        assertEquals(0, result.get(LottoMatchStatus.SIX_MATCH_RESULT) != null ? result.get(LottoMatchStatus.SIX_MATCH_RESULT) : 0);
        assertEquals(1, result.get(LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT) != null ? result.get(LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT) : 0);
    }
}
