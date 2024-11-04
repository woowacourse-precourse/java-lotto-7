package lotto.controller;

import static lotto.view.OutputView.printLottoBundleResultHeader;
import static lotto.view.OutputView.printLottoRankResult;
import static lotto.view.OutputView.printTotalProfit;

import lotto.model.LottoRanks;
import lotto.model.Wallet;
import lotto.utils.LottoRank;

public class LottoStatisticGenerator {
    public static void makeStatistic(LottoRanks lottoRanks, Wallet myWallet) {
        printLottoBundleResultHeader();
        for (LottoRank lottoRank : LottoRank.values()) {
            Integer count = (Integer) (int) lottoRanks.getLottoRanks().stream().filter(l -> l.equals(lottoRank)).count();
            printLottoRankResult(lottoRank, count);
        }
    }

    public static void calculateProfit(LottoRanks lottoRanks, Wallet wallet) {
        Double totalReward = Double.valueOf(lottoRanks.getLottoRanks().stream().mapToInt(LottoRank::getReward).sum());
        Double profit = (totalReward / wallet.getMoney()) * 100;
        String profitArgument = String.format("%.1f", profit);
        printTotalProfit(profitArgument);
    }
}
