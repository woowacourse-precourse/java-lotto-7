package lotto.service;

import lotto.domain.Rank;
import lotto.domain.lottos.Lotto;
import lotto.domain.lottos.RandomLottos;
import lotto.domain.lottos.user.BonusLotto;
import lotto.domain.lottos.user.UserLotto;
import lotto.domain.lottos.user.WinningLottos;

public class LottoMatchService {
    private final UserLotto userLotto;
    private final RandomLottos randomLottos;
    private final WinningLottos winningLottos;

    public LottoMatchService(RandomLottos randomLottos, UserLotto userLotto, WinningLottos winningLottos) {
        this.randomLottos = randomLottos;
        this.userLotto = userLotto;
        this.winningLottos = winningLottos;
    }

    /**
     * 개수 확인하고
     * winningLotto에 해당 Rank 넣기
     * 캡슐화??
     * Lotto에 get만 없으면 되지 않나?
     */

    public void matchLottos(){
        Lotto maninLotto = userLotto.getMainLotto();
        BonusLotto bonusLotto = userLotto.getBonusLotto();

        for(Lotto randomLotto : randomLottos.getLottos()){
            int numberOfMatches = maninLotto.getNumberOfMatches(randomLotto);
            boolean isContainBonus = bonusLotto.isContainMainLotto(randomLotto);
            Rank matchedRank = Rank.findRank(numberOfMatches, isContainBonus);

            winningLottos.addRank(matchedRank);
        }
    }

}
