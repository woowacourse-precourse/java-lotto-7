package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Collections;

public class PublishLottoService {
    public static Lotto publishLotto() {
        return new Lotto((Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }
}
