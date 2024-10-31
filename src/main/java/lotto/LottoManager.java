package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;

public class LottoManager {
    private List<LottoRank> ranks = new ArrayList<>();

    public LottoManager(){
        ranks.add(new LottoRank(1, 2000000000, 6, false));
        ranks.add(new LottoRank(2, 30000000, 5, true));
        ranks.add(new LottoRank(3, 1500000, 5, false));
        ranks.add(new LottoRank(4, 50000, 4, false));
        ranks.add(new LottoRank(5, 5000, 3, false));
    }

    public List<Lotto> generateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLotto()));
        }
        return lottos;
    }

    private List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
