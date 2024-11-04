package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class LottoGenerator {
    public List<Lotto> getPurchasedLotto(int count) {
        List<Lotto> lotto = new ArrayList<>();

        for(int i=0; i<count; i++) {
            List<Integer> pickedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.add(new Lotto(pickedNumbers));
        }

        return lotto;
    }
}
