package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.common.LottoRank;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
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
}