package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoShop {

    public Lottos buyLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        while (amount-- > 0) {
            lottos.add(generateLotto());
        }

        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(pickedNumbers);
    }
}
