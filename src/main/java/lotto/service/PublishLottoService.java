package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

public class PublishLottoService {
    public static Lotto publishLotto() {
        return new Lotto((Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }
}
