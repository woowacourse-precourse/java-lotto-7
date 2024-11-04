package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Issuer {
    public List<Lotto> getIssuedLotteries(Integer purchaseAmount) {
        return issueLotteries(purchaseAmount);
    }

    private List<Lotto> issueLotteries(Integer purchaseAmount) {
        int purchaseCount = purchaseAmount / 1000;
        List<Lotto> issuedLotto = new ArrayList<>();

        createLottoOnRandom(purchaseCount, issuedLotto);
        return issuedLotto;
    }

    private void createLottoOnRandom(int purchaseCount, List<Lotto> issuedLotto) {
        while (purchaseCount > 0){
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            issuedLotto.add(new Lotto(randomLottoNumbers));
            purchaseCount --;
        }
    }
}
