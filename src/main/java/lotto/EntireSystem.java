package lotto;

import lotto.analytics.Analyzer;
import lotto.purchase.LottoCreationManager;
import lotto.purchase.LottoReceipt;
import lotto.statistics.DrawResultSheet;
import lotto.statistics.LottoStatisticsManager;

public class EntireSystem {

    public void run() {
        LottoReceipt lottoReceipt = new LottoCreationManager().process();
        Analyzer analyzer = new Analyzer();

        System.out.println();

        lottoReceipt.printTotalLottoNumber();
        lottoReceipt.printAllLotteries();

        System.out.println();

        DrawResultSheet drawResultSheet = new LottoStatisticsManager(lottoReceipt.myLotteries()).process();

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        drawResultSheet.printDrawResult();

        long payment = lottoReceipt.payment();
        long totalPrizeAmount = drawResultSheet.calculateTotalPrizeAmount();
        analyzer.tellGrowthRate(payment, totalPrizeAmount);
    }
}
