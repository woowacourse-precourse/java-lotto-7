package lotto.lottoMachine.calculateManager;

import java.util.List;
import lotto.Lotties;
import lotto.Lotto;
import lotto.lottoMachine.lottoRank.LottoRankResultProcessor;

public class LotteryResultManager {
    private static final int NUMBER_MATCH_TO_BE_SECOND_IN_THE_LOTTERY = 5;

    private final List<Integer> lottoWinningNumber;
    private final int lottoBonusNumber;
    private LottoRankResultProcessor lottoRankResultProcessor;
    private Lotties lotties;

    public LotteryResultManager(List<Integer> lottoWinningNumber, int lottoBonusNumber,
                                LottoRankResultProcessor lottoRankResultProcessor, Lotties lotties) {
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoRankResultProcessor = lottoRankResultProcessor;
        this.lotties = lotties;
    }

    public void manageLotteryResults() {
        List<Lotto> lottoTickets = lotties.getLottoTickets();
        lottoTickets.forEach(this::processLottoTicket);
    }

    private void processLottoTicket(Lotto lottoTicket) {
        int amountOfLottoNumberMatch = lottoTicket.calculateAmountNumbersThatMatchWinningNumbers(lottoWinningNumber);
        boolean isMatchBonusNumber = (amountOfLottoNumberMatch == NUMBER_MATCH_TO_BE_SECOND_IN_THE_LOTTERY)
                && lottoTicket.isMatchBonusNumber(lottoBonusNumber);

        storeLotteryResult(amountOfLottoNumberMatch, isMatchBonusNumber);
    }

    private void storeLotteryResult(int amountOfLottoNumberMatch, boolean isMatchBonusNumber) {
        lottoRankResultProcessor.store(amountOfLottoNumberMatch, isMatchBonusNumber);
    }
}
