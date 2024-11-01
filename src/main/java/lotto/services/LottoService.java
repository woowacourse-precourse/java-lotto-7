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


    // 로또 통계 데이터 객체를 생성하여 반환합니다.
    public LottoStatistic createLottoStatistics(int purchaseAmount, int quantity) {
        return new LottoStatistic(purchaseAmount, quantity);
    }

    // 사용자의 로또 한장, 랜덤로또 N장, 통계데이터 객체를 전달받습니다.
    // 로또 당첨 여부를 확인하여 통계데이터를 업데이트합니다.
    public void checkLottoResults(LottoStatistics lottoStatistic, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber) {
        lottoStatistic.updateStatistics(randomLotteries, userLotto, bonusNumber);

    }
    // 업데이트된 로또 당첨 통계의 수익률을 계산합니다.
    public void checkLottoYield(LottoStatistics lottoStatistic) {
        lottoStatistic.updateLottoYield();
    }



}