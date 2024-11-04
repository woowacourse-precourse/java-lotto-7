package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {

    private final List<Lotto> lottos;

    public static MyLotto createLottos(int purchaseAmount, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generateLottos(purchaseAmount);
        return new MyLotto(lottos);
    }

    private MyLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getNumberOfLotto() {
        return lottos.size();
    }

    public List<Lotto> getMyLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoResultStatistic getResultStatistic(WinningLotto winningLotto) {
        LottoResultStatistic statistic = new LottoResultStatistic();
        for (Lotto lotto : lottos) {
            int count = lotto.lottoWinningStatus(winningLotto.getWinningLotto());
            boolean bonusHit = lotto.checkContainsBonusNumber(winningLotto.getBonusLottoNumber());
            statistic.updatePrize(Prize.getHit(count, bonusHit));
        }
        return statistic;
    }

    public void additionalLotto(Lotto lotto){
        lottos.add(lotto);
    }
}
