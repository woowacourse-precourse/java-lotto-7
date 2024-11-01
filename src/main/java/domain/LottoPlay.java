package domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoPlay {

    private final User user;
    private final LottoMachine lottoMachine;

    public LottoPlay(User user, LottoMachine lottoMachine) {
        this.user = user;
        this.lottoMachine = lottoMachine;
    }

    public void issueLotto() {
        int purchaseCount = this.user.getPurchaseCount();
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.ascNumber();
            lottos.add(lotto);
        }
        this.user.updateLottos(lottos);
    }
}
