package lotto.services;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoStatistics;
import java.util.List;

public interface LottoServices {
    Lotto createLotto(List<Integer> lotto);

    List<Lotto> createRandomLotteries(LottoStatistics statistics);

    LottoStatistic createLottoStatistics(int purchaseAmount, int quantity);

    void checkLottoResults(LottoStatistics lottoStatistic, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    void checkLottoYield(LottoStatistics lottoStatistic);
}
