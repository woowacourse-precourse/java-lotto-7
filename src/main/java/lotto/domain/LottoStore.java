package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

//- 역할
//  - 받은 금액만큼 로또를 발행한다
public class LottoStore {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    private static final int LOTTO_PRICE = 1000;

    public void buyLotto(int price) {
        for (int i = 0; i < price/LOTTO_PRICE; i++) {
            purchasedLottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Lotto> getPurchasedLottos() {
        return this.purchasedLottos;
    }


}
