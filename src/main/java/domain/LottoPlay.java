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

    public void drawLottos() {
        List<Integer> winningNumbers = this.lottoMachine.getWinningNumbers();
        for(Lotto lotto : this.user.getLottos()) {
            long matchCount = lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            if(matchCount == 5) {
                if(lotto.getNumbers().contains(this.lottoMachine.getBonusNumber())) {
                    this.user.addWinning(WinningLotto.SECOND);
                }
            }
            // TODO : 2등과 3등 구분할 수 있도록 변경하기
            user.addWinning(WinningLotto.from(matchCount));
        }
    }
}
