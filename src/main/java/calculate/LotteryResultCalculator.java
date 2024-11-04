package calculate;

import java.util.List;
import lotto.Lotties;
import lotto.Lotto;
import lottoRank.LottoRankResultProcessor;

public class LotteryResultCalculator {
    private final List<Integer> lottoWinningNumber;
    private final int lottoBonusNumber;
    private LottoRankResultProcessor lottoRankResultProcessor;
    private Lotties lotties;

    public LotteryResultCalculator(List<Integer> lottoWinningNumber, int lottoBonusNumber,
                                   LottoRankResultProcessor lottoRankResultProcessor, Lotties lotties) {
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoRankResultProcessor = lottoRankResultProcessor;
        this.lotties = lotties;
    }

    public void calculateLotteryResult() {
        List<Lotto> lottoTickets = lotties.getLottoTickets();

        lottoTickets.forEach(lottoTicket -> {
            int amountOfLottoNumberMatch = lottoTicket.calculateAmountNumbersThatMatchWinningNumbers(
                    lottoWinningNumber);
            boolean isMatchBonusNumber = false;

            if (amountOfLottoNumberMatch == 5) {
                isMatchBonusNumber = lottoTicket.isMatchBonusNumber(lottoBonusNumber);
            }

            lottoRankResultProcessor.store(amountOfLottoNumberMatch, isMatchBonusNumber);
        });
    }
}
