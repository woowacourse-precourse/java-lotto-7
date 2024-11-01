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

    public void setWinningLottoAndBonusNumber(Lotto winningLotto, int bonusLottoNumber) {
        if (winningLotto.isNumberInLottoResult(bonusLottoNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호에 포함이 안된 숫자여야 합니다");
        }
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }


}
