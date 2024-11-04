package lotto;

import lotto.analytics.AnalyticsManager;
import lotto.analytics.RateSheet;
import lotto.purchase.LottoCreationManager;
import lotto.purchase.LottoReceipt;
import lotto.statistics.DrawResultSheet;
import lotto.statistics.LottoStatisticsManager;

public class EntireSystem {

    public void run() {
        LottoReceipt lottoReceipt = new LottoCreationManager().process();

        insertBlankLine();

        lottoReceipt.printTotalLottoNumber();
        lottoReceipt.printAllLotteries();

        insertBlankLine();

        DrawResultSheet drawResultSheet = new LottoStatisticsManager(lottoReceipt.myLotteries()).process();

        insertBlankLine();

        drawResultSheet.printDrawResult();

        long payment = lottoReceipt.payment();
        long totalPrizeAmount = drawResultSheet.calculateTotalPrizeAmount();

        AnalyticsManager analyzer = new AnalyticsManager();
        RateSheet rateSheet = analyzer.process(payment, totalPrizeAmount);
        rateSheet.printGrowthRate();
    }

    private void insertBlankLine() {
        System.out.println();
    }
}
