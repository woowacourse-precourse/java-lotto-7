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
        checkPrizeCount();


    }

    //로또 당첨 금액 확인
    private void checkPrizeCount() {
        prizeCount.put(3, 0);
        prizeCount.put(4, 0);
        prizeCount.put(5, 0);
        prizeCount.put(6, 0);
        prizeCount.put(7, 0);
    }
    //당첨 결과 계산
    private void calculateResult() {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = getMatchCount(lotto);
            if (matchCount >= 3) {
                prizeCount.put(matchCount, prizeCount.get(matchCount) + 1);
            }else if(matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                prizeCount.put(7, prizeCount.get(7) + 1);
            }
        }
    }
    //구매한 로또 번호와 당첨번호 비교
    private int getMatchCount(Lotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
