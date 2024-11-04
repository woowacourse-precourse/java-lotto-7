package lotto.lottoMachine.calculateManager;

import java.util.List;
import lotto.Lotties;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.lottoMachine.lottoTotalResult.LottoTotalResultManager;

public class LotteryResultManager {
    private static final int NUMBER_MATCH_TO_BE_SECOND_IN_THE_LOTTERY = 5;

    private final List<Integer> lottoWinningNumber;
    private final int lottoBonusNumber;
    private LottoTotalResultManager lottoTotalResultManager;
    private Lotties lotties;

    public LotteryResultManager(List<Integer> lottoWinningNumber, int lottoBonusNumber,
                                LottoTotalResultManager lottoTotalResultManager, Lotties lotties) {
        this.lottoWinningNumber = lottoWinningNumber;
        this.lottoBonusNumber = lottoBonusNumber;
        this.lottoTotalResultManager = lottoTotalResultManager;
        this.lotties = lotties;
    }

    public void manageLotteryResults() {
        List<Lotto> lottoTickets = lotties.getLottoTickets();
        lottoTickets.forEach(this::processLottoTicket);
    }

    private void processLottoTicket(Lotto lottoTicket) {
        LottoResult lottoResult = compareLottoNumbersWithLottoWinningNumbers(lottoTicket);
        storeLotteryResult(lottoResult);
    }

    private LottoResult compareLottoNumbersWithLottoWinningNumbers(Lotto lottoTicket) {
        int amountOfLottoNumberMatch = lottoTicket.countMatchingNumbers(lottoWinningNumber);
        boolean isMatchBonusNumber = (amountOfLottoNumberMatch == NUMBER_MATCH_TO_BE_SECOND_IN_THE_LOTTERY)
                && lottoTicket.matchesBonusNumber(lottoBonusNumber);

        return new LottoResult(amountOfLottoNumberMatch, isMatchBonusNumber);
    }


    private void storeLotteryResult(LottoResult lottoResult) {
        int amountOfLottoNumberMatch = lottoResult.getMatchingCount();
        boolean isMatchBonusNumber = lottoResult.isMatchBonus();

        lottoTotalResultManager.store(amountOfLottoNumberMatch, isMatchBonusNumber);
    }
}
