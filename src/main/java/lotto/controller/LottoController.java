package lotto.controller;

import java.util.List;
import lotto.config.LottoInfo;
import lotto.dto.LottoDto;
import lotto.dto.StatisticDto;
import lotto.model.Lotteries;
import lotto.model.Lotto;
import lotto.model.Statistic;
import lotto.model.YieldRate;
import lotto.util.generator.RandomLottoNumberGenerator;
import lotto.view.LottoView;
import lotto.vo.BonusNumber;
import lotto.vo.BuyLottoAmount;
import lotto.vo.TicketCount;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        BuyLottoAmount buyLottoAmount = lottoView.promptBuyAmount();
        TicketCount ticketCount = calculateTicketCount(buyLottoAmount);

        Lotteries lotteries = createLotteries(ticketCount);
        displayLottoPurchaseInfo(ticketCount, lotteries);

        Lotto winningLotteries = inputWinningLotteries();
        BonusNumber bonusNumber = lottoView.promptBonusNumber(winningLotteries.getNumbers());

        Statistic statistic = generateStatistic(lotteries, winningLotteries, bonusNumber);
        YieldRate yieldRate = calculateYieldRate(statistic, buyLottoAmount);

        displayResult(statistic, yieldRate);
    }

    private TicketCount calculateTicketCount(BuyLottoAmount buyLottoAmount) {
        int count = buyLottoAmount.amount() / LottoInfo.LOTTO_TICKET_PRICE.getValue();

        return new TicketCount(count);
    }

    private Lotteries createLotteries(TicketCount ticketCount) {
        return Lotteries.createLotteries(ticketCount, new RandomLottoNumberGenerator());
    }

    private Statistic generateStatistic(Lotteries lotteries, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Integer> matchCount = lotteries.countMatchedNumbers(winningLotto);
        List<Boolean> bonusContain = lotteries.checkBonusNumberContain(bonusNumber);

        return Statistic.createStatistic(matchCount, bonusContain);
    }

    private YieldRate calculateYieldRate(Statistic statistic, BuyLottoAmount buyLottoAmount) {
        return YieldRate.createYieldRate(statistic.getStatisticResult(), buyLottoAmount);
    }

    private void displayLottoPurchaseInfo(TicketCount ticketCount, Lotteries lotteries) {
        lottoView.displayTicketCount(ticketCount);
        lottoView.displayLotteries(LottoDto.toDto(lotteries.getLotteries()));
    }

    private void displayResult(Statistic statistic, YieldRate yieldRate) {
        lottoView.displayStatistics(StatisticDto.from(statistic));
        lottoView.displayProfitRate(yieldRate.getRate());
    }

    private Lotto inputWinningLotteries() {
        List<Integer> winningNumbers = lottoView.promptWinningLotto();
        return Lotto.createWinningLotto(winningNumbers);
    }
}
