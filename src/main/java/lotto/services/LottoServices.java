package lotto.services;
import lotto.model.Lotto;
import lotto.model.LottoStatistic;
import lotto.model.LottoStatistics;
import java.util.List;

public interface LottoServices {
    // 한장의 로또 객체를 생성하여 반환합니다.
    public Lotto createLotto(List<Integer> lotto);

    public List<Lotto> createRandomLotteries(LottoStatistics statistics);

    LottoStatistic createLottoStatistics(int purchaseAmount, int quantity);

    public void checkLottoResults(LottoStatistics lottoStatistic, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    // 업데이트된 로또 당첨 통계의 수익률을 계산합니다.
    public void checkLottoYield(LottoStatistics lottoStatistic);


}
