package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.domain.lottoMatchChecker.DefaultLottoMatchChecker;
import lotto.domain.lottoMatchChecker.LottoMatchChecker;
import lotto.dto.data.Lotto;
import lotto.dto.data.WinningLotto;
import lotto.utils.LottoMatchStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DefaultLottoMatchCheckerTest {

    private LottoMatchChecker lottoMatchChecker;
    private WinningLotto winningLotto;

    @BeforeEach
    void beforeEach() {
        lottoMatchChecker = new DefaultLottoMatchChecker();
        winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void 번호_3개_일치_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 7, 8, 9)));
        lottos.add(new Lotto(List.of(4, 5, 7, 10, 11, 12)));

        HashMap<LottoMatchStatus, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoMatchStatus.THREE_MATCH_RESULT, 1);

        //when
        HashMap<LottoMatchStatus, Integer> actualResult = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 번호_4개_5개_일치_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 7, 8)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 9)));

        HashMap<LottoMatchStatus, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoMatchStatus.FOUR_MATCH_RESULT, 1);
        expectedResult.put(LottoMatchStatus.FIVE_MATCH_RESULT, 1);

        //when
        HashMap<LottoMatchStatus, Integer> actualResult = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 번호_5개_일치_보너스번호_일치_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        HashMap<LottoMatchStatus, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoMatchStatus.FIVE_MATCH_WITH_BONUS_RESULT, 1);

        //when
        HashMap<LottoMatchStatus, Integer> actualResult = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 번호_6개_일치_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        HashMap<LottoMatchStatus, Integer> expectedResult = new HashMap<>();
        expectedResult.put(LottoMatchStatus.SIX_MATCH_RESULT, 1);

        //when
        HashMap<LottoMatchStatus, Integer> actualResult = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void 번호_미일치_테스트() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));

        HashMap<LottoMatchStatus, Integer> expectedResult = new HashMap<>();

        //when
        HashMap<LottoMatchStatus, Integer> actualResult = lottoMatchChecker.countMatchingNumbers(winningLotto, lottos);

        //then
        assertEquals(expectedResult, actualResult);
    }
}