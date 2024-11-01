package lotto.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoBuyer;
import lotto.service.domain.money.Budget;
import lotto.service.domain.numbergenerator.RandomNumberGenerator;
import lotto.service.domain.numbergenerator.WoowaLottoGenerator;

public class LottoManager implements LottoValueProvider {
    private LottoBuyer lottoBuyer;

    @Override
    public Set<Lotto> makePurchasedLotto(int money) {
        Budget budget = new Budget(money);
        RandomNumberGenerator lottoGenerator = new WoowaLottoGenerator();
        this.lottoBuyer = makeLottoBuyer(budget, lottoGenerator);
        Set<Lotto> purchasedLotto = lottoBuyer.getPurchasedLotto();

        return purchasedLotto;
    }

    private LottoBuyer makeLottoBuyer(Budget budget, RandomNumberGenerator lottoGenerator) {
        int purchaseCount = (budget.getBudget() / 1_000);
        Set<Lotto> purchasedLotto = IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(lottoGenerator.makeLottoRandomNumber()))
                .collect(Collectors.toSet());

        return new LottoBuyer(purchasedLotto, budget);
    }

    @Override
    public void makeWinningStatistics() {

    }
}
