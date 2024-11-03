package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {

    public List<Lotto> buyLotto(int money) throws IllegalArgumentException {
        List<Lotto> lottos = new ArrayList<>();

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1000원 이상이어야 합니다.");
        }

        for (int i = 0; i < money / 1000; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }
}
