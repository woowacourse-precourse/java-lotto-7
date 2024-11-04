package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCheckerTest {

    private LottoResultChecker resultChecker;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        resultChecker = new LottoResultChecker(winningNumber, bonusNumber);
    }

    @Test
    @DisplayName("로또 당첨 내역 확인한다. ")
    void getLottoResult() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        resultChecker.checkLottoResult(lottos);
        Map<Rank, Integer> lottoResult = resultChecker.getLottoResult();

        assertEquals(1, lottoResult.get(Rank.FIFTH));
        assertEquals(0, lottoResult.get(Rank.FOURTH));
        assertEquals(0, lottoResult.get(Rank.THIRD));
        assertEquals(0, lottoResult.get(Rank.SECOND));
        assertEquals(0, lottoResult.get(Rank.FIRST));
    }
}