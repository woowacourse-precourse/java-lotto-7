package lotto.utility;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static Lotto generateLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }
}
