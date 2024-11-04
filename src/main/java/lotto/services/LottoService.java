package lotto.services;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoStatistics;
import java.util.ArrayList;
import java.util.List;

public class LottoService implements LottoServices {
    public Lotto createLotto(List<Integer> lotto) {
       return new Lotto(lotto);
    }

    public List<Lotto> createRandomLotteries(LottoStatistics statistics) {
        List<Lotto> RandomLotteries = new ArrayList<>();
        for (int i = 0; i < statistics.toDTO().quantity(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            RandomLotteries.add(new Lotto(numbers));
        }
        return RandomLotteries;
    }

    public LottoStatistic createLottoStatistics(int purchaseAmount, int quantity) {
        return new LottoStatistic(purchaseAmount, quantity);
    }

    public void checkLottoResults(LottoStatistics lottoStatistic, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        lottoStatistic.updateStatistics(randomLotteries, userLotto, bonusNumber);

    }

    public void checkLottoYield(LottoStatistics lottoStatistic) {
        lottoStatistic.updateLottoYield();
    }
}