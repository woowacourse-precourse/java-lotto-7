package lotto.week3.model;

import java.util.List;
import lotto.week3.domain.Lotto;

public class LottoMatching {

    private final List<Lotto> lottos;

    public LottoMatching(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void mathing(List<Integer> winningNumbers, int bonus){
        for(Lotto lotto : lottos){
            int matchCount = lotto.matchCount(winningNumbers);
            boolean contains = lotto.contains(bonus);
        }
    }


}
