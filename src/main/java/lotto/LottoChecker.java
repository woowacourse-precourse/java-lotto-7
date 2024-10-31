package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    List<LottoRank> lottoRanks = new ArrayList<>();


    public void checkLotto(List<Integer> winLotto, List<Lotto> issuedLottos, int bonusLotto){
        for (Lotto issuedLotto : issuedLottos) {
            long count = winLotto.stream()
                    .filter(issuedLotto.getNumbers()::contains)
                    .count();
            int bonus = 0;
            if(issuedLotto.getNumbers().contains(bonusLotto)){
                bonus++;
            }
            lottoRanks.add(getLottoRank(count, bonus));
        }
    }

    public List<LottoRank> getLottoRanks() {
        return lottoRanks;
    }

    private LottoRank getLottoRank(long count, long bonus) {
        if (count == 6) {
            return LottoRank.FIRST;
        }
        if( (count+bonus) == 6 ) {
            return LottoRank.SECOND;
        }
        if ((count+bonus) == 5) {
            return LottoRank.THIRD;
        }
        if ((count+bonus) == 4) {
            return LottoRank.FOURTH;
        }
        if ((count+bonus) == 3) {
            return LottoRank.FIFTH;
        }
        return LottoRank.MISS;
    }
}
