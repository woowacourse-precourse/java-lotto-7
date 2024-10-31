package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class LottoBuyer {

    private long lottoCount;
    private ArrayList<Lotto> lottos = new ArrayList<>();

    private Lotto winningLotto;
    private int bonusLottoNumber;

    public LottoBuyer(long lottoCount) {
        this.lottoCount = lottoCount;
        addLotto();
    }

    private void addLotto() {
        for (long i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
            lotto.printLotto();
        }
    }

}
