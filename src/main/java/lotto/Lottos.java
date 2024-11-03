package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> compareWithWinLotto(WinLotto winLotto) {
        List<Integer> winLottoNumbers = winLotto.getWinLottoNumbers();
        List<Rank> ranks = new ArrayList<>();;
        for (Lotto lotto : lottos) {
            Integer matched = lotto.compareWithWinLotto(winLottoNumbers);
            if (matched != 5)  {
                ranks.add(Rank.valueOf(matched, false));
                continue;
            }
            if (lotto.getNumbers().contains(winLotto.getBonus())) {
                ranks.add(Rank.valueOf(matched, true));
                continue;
            }
            ranks.add(Rank.valueOf(matched, false));
        }
        return ranks;
    }
}
