package lotto.week3.domain;

import java.util.List;
import lotto.week3.domain.Lotto;
import lotto.week3.model.LottoStatistics;

public class LottoMatching {

    private final List<Lotto> lottos;
    private final LottoStatistics lottoStatistics;


    public LottoMatching(List<Lotto> lottos, LottoStatistics lottoStatistics) {
        this.lottos = lottos;
        this.lottoStatistics = lottoStatistics;
    }

    public void mathing(List<Integer> winningNumbers, int bonus){
        for(Lotto lotto : lottos){
            int matchCount = lotto.matchCount(winningNumbers);
            boolean contains = lotto.contains(bonus);
            lottoStatistics.calculatePrize(matchCount, contains);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoStatistics getLottoStatistics() {
        return lottoStatistics;
    }
}
