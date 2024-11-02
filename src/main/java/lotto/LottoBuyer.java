package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class LottoBuyer {
    private final ArrayList<Lotto> lottos = new ArrayList<>();

    private Lotto winningLotto;
    private int bonusLottoNumber;

    public LottoBuyer(long lottoCount) {
        buyLotto(lottoCount);
    }

    private void buyLotto(long lottoCount) {
        for (long i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            lotto.printLotto();
        }
    }

    public void setWinningLottoAndBonusNumber(Lotto winningLotto, int bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }


}
