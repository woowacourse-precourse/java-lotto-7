package lotto.service;

import lotto.config.LottoConfig;
import lotto.domain.*;
import lotto.message.LottoMessage;
import lotto.view.LottoPrinter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottoService {

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;
    private final Statistics statistics = new Statistics();
    private final LottoPrinter lottoPrinter;

    public LottoService(List<Lotto> lottos, WinningLotto winningLotto, BonusNumber bonusNumber, LottoPrinter lottoPrinter) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.lottoPrinter = lottoPrinter;
    }

    public void announceResult() {
        Lotto winningNumbers = winningLotto.getWinningNumber();
        int bonus = bonusNumber.number();
        long totalPrize = calculateTotalPrize(winningNumbers, bonus);
        printStatistics(totalPrize);
    }

    private long calculateTotalPrize(Lotto winningNumbers, int bonus) {
        long totalPrize = 0;
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningNumbers, bonus);
            if (rank != Rank.NONE) {
                statistics.addRank(rank);
                totalPrize += rank.getPrize();
            }
        }
        return totalPrize;
    }

    private void printStatistics(long totalPrize) {
        lottoPrinter.printMessage(LottoMessage.RESULT);
        Map<Rank, Integer> rankCountMap = statistics.getRankCountMap();

        List<Rank> orderedRanks = Arrays.asList(
            Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

        for (Rank rank : orderedRanks) {
            int count = rankCountMap.getOrDefault(rank, 0);
            lottoPrinter.printResult(rank, count);
        }

        long totalInvestment = lottos.size() * LottoConfig.LOTTO_PRICE;
        double yield = statistics.calculateYield(totalPrize, totalInvestment);
        lottoPrinter.printYield(yield);
    }

    public Statistics getStatistics() {
        return statistics;
    }
}
