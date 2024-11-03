package lotto.business;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.business.contract.ContractStrategy;
import lotto.business.draw.DrawStrategy;
import lotto.business.issue.IssueStrategy;
import lotto.io.IOManager;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

public class LottoShop {
    private final IOManager ioManager;
    private final Money lottoPrice;
    private final ContractStrategy contractStrategy;
    private final IssueStrategy issueStrategy;
    private final DrawStrategy drawStrategy;

    public LottoShop(IOManager ioManager, Money lottoPrice,
                     ContractStrategy contractStrategy, IssueStrategy issueStrategy, DrawStrategy drawStrategy) {
        this.ioManager = ioManager;
        this.lottoPrice = lottoPrice;
        this.contractStrategy = contractStrategy;
        this.issueStrategy = issueStrategy;
        this.drawStrategy = drawStrategy;
    }

    public List<Lotto> sellLotto() {
        Money inputMoney = contractStrategy.sellLotto();
        int numOfLotto = inputMoney.divide(lottoPrice);
        List<Lotto> lotteriesBuy = issueStrategy.issueMany(numOfLotto);
        contractStrategy.printBill(lotteriesBuy);
        return lotteriesBuy;
    }

    public LottoResult draw() {
        return drawStrategy.draw();
    }

    public void printResult(List<Lotto> lotteries, LottoResult lottoResult) {
        ioManager.printMessage("당첨 통계");
        ioManager.printMessage("---");
        List<LottoPrize> lottoPrizes = LottoPrize.from(lotteries, lottoResult);
        printWinningPrizes(lottoPrizes);
        printProfitRate(lotteries, lottoPrizes);
    }

    private void printWinningPrizes(List<LottoPrize> lottoPrizes) {
        Arrays.stream(LottoPrize.values())
                .sorted(Comparator.reverseOrder())
                .filter(lottoPrize -> lottoPrize != LottoPrize.NONE)
                .forEach(targetPrize -> printWinningPrize(targetPrize, lottoPrizes));
    }

    private void printWinningPrize(LottoPrize targetPrize, List<LottoPrize> lottoPrizes) {
        int count = Collections.frequency(lottoPrizes, targetPrize);
        ioManager.printMessage(targetPrize.toString() + " - " + count + "개");
    }

    private void printProfitRate(List<Lotto> lotteries, List<LottoPrize> lottoPrizes) {
        double profitRate = calculateProfitRate(lotteries, lottoPrizes);
        DecimalFormat df = new DecimalFormat("#,##0.0");
        ioManager.printMessage("총 수익률은 " + df.format(profitRate * 100) + "%입니다.");
    }

    private double calculateProfitRate(List<Lotto> lotteries, List<LottoPrize> lottoPrizes) {
        int moneyUsed = lottoPrice.multiply(lotteries.size());
        if (moneyUsed == 0) {
            return 0;
        }

        int totalRewards = LottoPrize.sumOfRewards(lottoPrizes);
        return (double) totalRewards / moneyUsed;
    }
}
