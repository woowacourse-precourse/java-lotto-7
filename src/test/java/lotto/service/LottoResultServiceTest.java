package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.PurchaseAmount;
import lotto.model.Winning;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {

    private LottoResultService lottoResultService;

    @BeforeEach
    void setUp() {
        WinningNumbers winningNumbers = WinningNumbers.from(List.of(
                LottoNumber.from(2),
                LottoNumber.from(12),
                LottoNumber.from(4),
                LottoNumber.from(30),
                LottoNumber.from(5),
                LottoNumber.from(14)
        ));

        BonusNumber bonusNumber = BonusNumber.from(LottoNumber.from(3));

        lottoResultService = new LottoResultService(winningNumbers, bonusNumber);
    }

    @Test
    void 당첨_기준에_따라_구입한_로또의_당첨을_확인한다() {
        // given
        Lotto lotto1 = Lotto.from(List.of(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
        ));

        Lotto lotto2 = Lotto.from(List.of(
                LottoNumber.from(2),
                LottoNumber.from(12),
                LottoNumber.from(4),
                LottoNumber.from(30),
                LottoNumber.from(5),
                LottoNumber.from(14)
        ));

        Lotto lotto3 = Lotto.from(List.of(
                LottoNumber.from(3),
                LottoNumber.from(12),
                LottoNumber.from(4),
                LottoNumber.from(30),
                LottoNumber.from(5),
                LottoNumber.from(14)
        ));

        List<Lotto> lottoTickets = List.of(lotto1, lotto2, lotto3);

        WinningNumbers winningNumbers = WinningNumbers.from(List.of(
                LottoNumber.from(2),
                LottoNumber.from(12),
                LottoNumber.from(4),
                LottoNumber.from(30),
                LottoNumber.from(5),
                LottoNumber.from(14)
        ));

        BonusNumber bonusNumber = BonusNumber.from(LottoNumber.from(3));

        // when
        Map<Winning, Integer> winningResults = lottoResultService.getWinningResults(lottoTickets);

        // then
        Map<Winning, Integer> expected = Map.of(
                Winning.FIRST, 1,
                Winning.SECOND, 1,
                Winning.FIFTH, 1
        );
        assertEquals(winningResults, expected);
    }

    @Test
    void 당첨_결과에_따라_수익률을_계산한다() {
        // given
        Map<Winning, Integer> winningResults = Map.of(
                Winning.FIRST, 1,
                Winning.SECOND, 1,
                Winning.FIFTH, 1
        );

        // when
        double rateOfReturn = lottoResultService.calculateRateOfReturn(PurchaseAmount.from(8000), winningResults);

        // then
        assertEquals(25375062.5, rateOfReturn);
    }
}