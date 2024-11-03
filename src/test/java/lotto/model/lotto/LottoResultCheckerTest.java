package lotto.model.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.model.winning.WinningNumbersAndBonusNumber;

public class LottoResultCheckerTest {

    private WinningNumbersAndBonusNumber winningNumbersAndBonusNumber;
    private LottoResultChecker lottoResultChecker;

    @BeforeEach
    void setUp() {
        winningNumbersAndBonusNumber = new WinningNumbersAndBonusNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoResultChecker = new LottoResultChecker(winningNumbersAndBonusNumber);
    }

    @Test
    @DisplayName("일치하는 번호가 3개일 경우 결과를 올바르게 반환해야 한다.")
    void shouldReturnResultWithMatchCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lottos lottos = new Lottos(List.of(lotto));

        List<LottoResult> results = lottoResultChecker.check(lottos);
        LottoResult result = results.getFirst();

        assertEquals(3, result.getMatchingCount());
    }

    @Test
    @DisplayName("일치하는 번호가 5개이고 보너스 번호 포함일 경우 결과를 올바르게 반환해야 한다.")
    void shouldReturnResultWithMatchCountAndBonus() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lottos lottos = new Lottos(List.of(lotto));

        List<LottoResult> results = lottoResultChecker.check(lottos);
        LottoResult result = results.getFirst();

        assertEquals(5, result.getMatchingCount());
        assertTrue(result.hasBonus());
    }

    @Test
    @DisplayName("일치하는 번호가 5개이고 보너스 번호 미포함일 경우 결과를 올바르게 반환해야 한다.")
    void shouldReturnResultWithMatchCountAndWithoutBonus() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lottos lottos = new Lottos(List.of(lotto));

        List<LottoResult> results = lottoResultChecker.check(lottos);
        LottoResult result = results.getFirst();

        assertEquals(5, result.getMatchingCount());
        assertFalse(result.hasBonus());
    }

    @Test
    @DisplayName("일치하는 번호가 없을 경우 결과를 올바르게 반환해야 한다.")
    void shouldReturnResultWithNotingMatches() {
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
        Lottos lottos = new Lottos(List.of(lotto));

        List<LottoResult> results = lottoResultChecker.check(lottos);
        LottoResult result = results.getFirst();

        assertEquals(0, result.getMatchingCount());
        assertFalse(result.hasBonus());
    }

}
