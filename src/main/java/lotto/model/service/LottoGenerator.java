package lotto.model.service;

import static lotto.model.domain.LottoConstant.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public List<Integer> getLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, SIZE);
    }
}
