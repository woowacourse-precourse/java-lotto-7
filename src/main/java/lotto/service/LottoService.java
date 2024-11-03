package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import lotto.Lotto;

public class LottoService {

    public static void getLottoNums() {
        for (int i = 1; i <= InputService.lottoAmount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }
}
