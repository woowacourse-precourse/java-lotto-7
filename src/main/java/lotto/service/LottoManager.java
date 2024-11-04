package lotto.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoBuyer;
import lotto.service.domain.lotto.LottoNumber;
import lotto.service.domain.lotto.LottoReward;
import lotto.service.domain.lottoresult.LottoWinCalculator;
import lotto.service.domain.lottoresult.LottoWinNumber;
import lotto.service.domain.money.Budget;
import lotto.service.domain.numbergenerator.RandomNumberGenerator;
import lotto.service.domain.numbergenerator.WoowaLottoGenerator;
import lotto.service.domain.statistics.StatisticsReport;

public class LottoManager implements LottoValueProvider {
    private LottoBuyer lottoBuyer;
    private LottoWinNumber lottoWinNumber;
    private StatisticsReport statisticsReport;

    @Override
    public List<Lotto> makePurchasedLotto(int money) {
        Budget budget = new Budget(money);
        RandomNumberGenerator lottoGenerator = new WoowaLottoGenerator();
        this.lottoBuyer = makeLottoBuyer(budget, lottoGenerator);
        List<Lotto> purchasedLotto = lottoBuyer.getPurchasedLotto();

        return purchasedLotto;
    }

    private LottoBuyer makeLottoBuyer(Budget budget, RandomNumberGenerator lottoGenerator) {
        int purchaseCount = (budget.getBudget() / 1_000);
        List<Lotto> purchasedLotto = IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(lottoGenerator.makeLottoRandomNumber()))
                .collect(Collectors.toList());

        return new LottoBuyer(purchasedLotto, budget);
    }

    @Override
    public StatisticsReport makeWinningStatistics(List<Integer> winnngNumber, int bonusNumber) {
        this.lottoWinNumber = new LottoWinNumber(new Lotto(winnngNumber), new LottoNumber(bonusNumber));
        List<LottoReward> lottoRewardsInfo = LottoWinCalculator.calculateReward(this.lottoBuyer, this.lottoWinNumber);
        this.statisticsReport = new StatisticsReport(lottoRewardsInfo, this.lottoBuyer);

        return statisticsReport;
    }
}
