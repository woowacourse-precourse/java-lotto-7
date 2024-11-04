package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoGameTest {

    private LottoGame lottoGame;
    private List<Integer> winningNumber;
    private int bonusNumber;
    private List<Lotto> purchasedLottoList;

    @BeforeEach
    void setUp() {
        winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        purchasedLottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)),
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))
        );

        lottoGame = new LottoGame(winningNumber, bonusNumber, purchasedLottoList);
    }

    @Test
    void 결과_확인_기능() {
        Map<LottoRank, Integer> lottoResult = lottoGame.checkLottoResult();

        assertEquals(1, lottoResult.get(LottoRank.FIRST));
        assertEquals(1, lottoResult.get(LottoRank.SECOND));
        assertEquals(1, lottoResult.get(LottoRank.THIRD));
        assertEquals(1, lottoResult.get(LottoRank.FOURTH));
        assertEquals(1, lottoResult.get(LottoRank.FIFTH));
    }

    @Test
    void 수익률_계산_기능() {
        int purchaseAmount = 5000;
        double expectedStatisticsResult =
                (2_000_000_000.0 + 30_000_000.0 + 1_500_000.0 + 50_000.0 + 5_000.0) / purchaseAmount * 100;

        lottoGame.checkLottoResult();
        double statisticResult = lottoGame.calculateStatistics(purchaseAmount);

        assertEquals(expectedStatisticsResult, statisticResult, 0.1);
    }
}
