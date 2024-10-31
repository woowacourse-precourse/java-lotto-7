package lotto.services;

import lotto.model.Lotto;
import lotto.model.LottoStatistics;

import java.util.List;

public interface LottoServices {
    // 한장의 로또 객체를 생성하여 반환합니다.
    public Lotto createLotto(List<Integer> lotto);

    public List<Lotto> createRandomLotteries(int quantity);

    // 로또 통계 데이터 객체를 생성하여 반환합니다.
    public LottoStatistics createLottoStatistics();

    // 사용자의 로또 한장, 랜덤로또 N장, 통계데이터 객체를 전달받습니다.
    // 로또 당첨 여부를 확인하여 통계데이터를 업데이트합니다.
    public void checkLottoResults(LottoStatistics lottoStatistics, List<Lotto> randomLotteries, Lotto userLotto, int bonusNumber);

    // 업데이트된 로또 당첨 통계의 수익률을 계산합니다.
    public void calculateLottoYield(LottoStatistics lottoStatistics, int amount);


}
