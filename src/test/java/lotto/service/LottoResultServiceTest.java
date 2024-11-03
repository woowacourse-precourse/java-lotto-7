package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.common.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoPurchasePrice;
import lotto.model.LottoResult;
import lotto.model.ReturnRate;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
@DisplayName("LottoResultService 기능 테스트")
class LottoResultServiceTest {
    private final LottoResultService lottoResultService = new LottoResultService();

    @DisplayName("로또 번호가 당첨 번호와 6개가 일치하면 1등의 당첨 카운트가 증가한다.")
    @Test
    void increaseFirstRankCountWhenFirstRankIsWin() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(lotto);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when
        LottoResult result = lottoResultService.getLottoResult(lottos, winningNumbers, bonusNumber);

        // then
        assertEquals(1, result.getWinningCount(LottoRank.FIRST));
    }

    @DisplayName("로또 번호가 당첨 번호와 5개 일치하고, 보너스 번호가 일차한다면 2등의 당첨 카운트가 증가한다.")
    @Test
    void increaseSecondRankCountWhenSecondRankIsWin() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        List<Lotto> lottos = List.of(lotto);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // when
        LottoResult result = lottoResultService.getLottoResult(lottos, winningNumbers, bonusNumber);

        // then
        assertEquals(1, result.getWinningCount(LottoRank.SECOND));
    }

    @DisplayName("8000원으로 8개의 로또를 구매해서 5등에 당첨되면 총 수익률은 62.5%이다.")
    @Test
    void calculateReturnRate() {
        // given
        LottoPurchasePrice purchasePrice = new LottoPurchasePrice(8000);
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
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoResult lottoResult = lottoResultService.getLottoResult(lottos, winningNumbers, bonusNumber);

        // when
        ReturnRate returnRate = lottoResultService.calculateReturnRate(lottoResult, purchasePrice);

        // then
        assertEquals(62.5, returnRate.returnRate());
    }
}