package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Issuer {
    public List<Lotto> issueLotto(Integer purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000원으로 나누어 떨어져야합니다.");// 1000 단위 아닐 시 예외
        }
        List<Lotto> issuedLotto = new ArrayList<>();
        createLottoOnRandom(purchaseAmount, issuedLotto);
        return issuedLotto;
    }

    private void createLottoOnRandom(Integer purchaseAmount, List<Lotto> issuedLotto) {
        int purchaseCount = purchaseAmount / 1000;
        while (purchaseCount > 0){
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            issuedLotto.add(new Lotto(randomLottoNumbers));
            purchaseCount --;
        }
    }
}
