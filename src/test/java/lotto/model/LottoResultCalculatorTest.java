package lotto.model;

import static lotto.model.LottoRank.FIRST;
import static lotto.model.LottoRank.SECOND;
import static lotto.model.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lotto.dto.LottoResult;
import lotto.dto.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultCalculatorTest {

    @Test
    @DisplayName("당첨 등수를 모두 반환한다.")
    void should_ReturnAllLottoRanks() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
        Lotto firstLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto secondLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoTickets lottoTickets = new LottoTickets(List.of(firstLottoTicket, secondLottoTicket, thirdLottoTicket));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        // when
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto);
        LottoResult lottoResult = lottoResultCalculator.getLottoResult(lottoTickets, purchaseAmount);
        Map<LottoRank, Integer> ranks = lottoResult.ranks();

        // then
        int firstPlaceCount = ranks.getOrDefault(FIRST, 0);
        int secondPlaceCount = ranks.getOrDefault(SECOND, 0);
        int thirdPlaceCount = ranks.getOrDefault(THIRD, 0);

        assertAll(
                () -> assertThat(firstPlaceCount).isOne(),
                () -> assertThat(secondPlaceCount).isOne(),
                () -> assertThat(thirdPlaceCount).isOne()
        );
    }

    @Test
    @DisplayName("총 당첨 수익률을 반환한다. - 1")
    void should_ReturnTotalPrizeFromWinningLotto() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(3000);
        Lotto firstLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLottoTicket = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoTickets lottoTickets = new LottoTickets(List.of(firstLottoTicket, secondLottoTicket));

        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        // when
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto);
        LottoResult lottoResult = lottoResultCalculator.getLottoResult(lottoTickets, purchaseAmount);

        // then
        BigDecimal expected = new BigDecimal("67666666.700").setScale(3, RoundingMode.HALF_EVEN);
        assertEquals(lottoResult.profitRate(), expected);
    }

    @Test
    @DisplayName("총 당첨 수익률을 반환한다. - 2")
    void should_ReturnTotalPrizeFromWinningLotto2() {
        // given
        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        LottoTickets lottoTickets = new LottoTickets(lottos);
        Lotto winningLottoNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        // when
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(winningLotto);
        LottoResult lottoResult = lottoResultCalculator.getLottoResult(lottoTickets, purchaseAmount);

        // then
        BigDecimal expected = new BigDecimal("62.5").setScale(3, RoundingMode.HALF_EVEN);
        assertEquals(lottoResult.profitRate(), expected);
    }
}
