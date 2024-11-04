package lotto;

import lotto.analytics.AnalyticsManager;
import lotto.analytics.RateSheet;
import lotto.purchase.LottoCreationManager;
import lotto.purchase.LottoReceipt;
import lotto.statistics.DrawResultSheet;
import lotto.statistics.LottoStatisticsManager;

public class EntireSystem {

    private final LottoCreationManager lottoCreationManager;
    private final LottoStatisticsManager lottoStatisticsManager;
    private final AnalyticsManager analyzer;

    public EntireSystem(LottoCreationManager lottoCreationManager,
                        LottoStatisticsManager lottoStatisticsManager,
                        AnalyticsManager analyzer) {
        this.lottoCreationManager = lottoCreationManager;
        this.lottoStatisticsManager = lottoStatisticsManager;
        this.analyzer = analyzer;
    }

    public void run() {
        LottoReceipt lottoReceipt = lottoCreationManager.process();

        lottoReceipt.printTotalLottoNumber();
        lottoReceipt.printAllLotteries();

        DrawResultSheet drawResultSheet = lottoStatisticsManager.process(lottoReceipt.myLotteries());

        drawResultSheet.printDrawResult();

        long payment = lottoReceipt.payment();
        long totalPrizeAmount = drawResultSheet.calculateTotalPrizeAmount();

        RateSheet rateSheet = analyzer.process(payment, totalPrizeAmount);
        rateSheet.printGrowthRate();
    }
}

