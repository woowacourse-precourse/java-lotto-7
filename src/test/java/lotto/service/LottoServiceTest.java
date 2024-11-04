package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.LottoWinningTier;
import lotto.domain.LottoWinningTierManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoServiceTest {
    LottoService lottoService;
    LottoWinningTierManager lottoWinningTierManager;
    @BeforeEach
    void setUp () {
        lottoService = new LottoService();
        setLottoNumbersForTest(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(6, 12, 25, 31, 38, 42)))
        );

        lottoWinningTierManager = new LottoWinningTierManager();
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.NONE, 0);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_THREE, 1);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FOUR, 0);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FIVE, 0);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_FIVE_WITH_BONUS, 0);
        lottoWinningTierManager.getLottoWinningTiers().put(LottoWinningTier.MATCH_SIX, 0);
    }
    // 접근 제어자를 생략하여 같은 패키지에서만 사용 가능하여 테스트 코드에서만 사용 가능
    void setLottoNumbersForTest (List<Lotto> lottoNumbersForTest) {
        lottoService.getLottoNumbers().clear();
        lottoService.getLottoNumbers().addAll(lottoNumbersForTest);
    }

    @Test
    void 로또_구매() {
        // given
        int purchaseCount = 100;
        lottoService.getLottoNumbers().clear();

        // when & then
        assertDoesNotThrow(() -> lottoService.purchaseLotto(purchaseCount));
    }

    @Test
    void 당첨된_로또_증가() {
        // given
        LottoWinningNumbers winningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        // when
        lottoService.updateWinningStatus(lottoWinningTierManager, winningNumbers);

        // then
        assertEquals(
                1,
                lottoWinningTierManager.getLottoWinningTiers().get(LottoWinningTier.MATCH_SIX));
    }

    @Test
    void 수익률_계산() {
        // when
        double result = lottoService.calculateTotalProfitRate(lottoWinningTierManager);

        // then
        assertEquals(250.0,
                result);
    }
}