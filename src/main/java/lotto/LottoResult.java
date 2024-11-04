package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<Integer, Integer> prizeCount = new HashMap<>();

    //결과물 생성자 구현
    public LottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        this.purchasedLottos = purchasedLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;

    }

    //로또 당첨 금액 확인
    private void checkPrizeCount() {
        prizeCount.put(3, 0);
        prizeCount.put(4, 0);
        prizeCount.put(5, 0);
        prizeCount.put(6, 0);
        prizeCount.put(7, 0);
    }
}
