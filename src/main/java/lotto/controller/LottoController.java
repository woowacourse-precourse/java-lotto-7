package lotto.controller;

import static java.util.Arrays.stream;
import static lotto.controller.LottoDraw.getBonusNumber;
import static lotto.controller.LottoDraw.getWinningNumbers;
import static lotto.controller.LottoSales.issueLottoes;
import static lotto.controller.LottoSales.makeDeposit;
import static lotto.controller.LottoStatistics.calculateWholeCashPrize;
import static lotto.controller.LottoStatistics.getStatistics;
import static lotto.view.OutputView.printEarningsRate;
import static lotto.view.OutputView.printWinningStatistics;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Deposit;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;
import lotto.model.Rank;
import lotto.model.WinningNumbers;

public class LottoController {
    public void run() {
        Deposit deposit = makeDeposit();
        List<Lotto> lottoes = issueLottoes(deposit.getNumberOfLottoes());

        WinningNumbers winningNumbers = getWinningNumbers();
        BonusNumber bonusNumber = getBonusNumber(winningNumbers);

        List<MatchingRecord> matchingRecords = stream(Rank.values()).map(MatchingRecord::new).toList();
        getStatistics(matchingRecords, lottoes, winningNumbers, bonusNumber);
        printWinningStatistics(matchingRecords);

        double wholeCashPrize = calculateWholeCashPrize(matchingRecords);
        printEarningsRate(((wholeCashPrize / (double) deposit.getPurchaseAmount()) * 100));
    }
}
