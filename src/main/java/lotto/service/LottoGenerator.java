package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.config.LottoGameConfig;
import lotto.domain.Lotto;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoGameConfig.LOTTO_MIN_NUMBER,
                LottoGameConfig.LOTTO_MAX_NUMBER, LottoGameConfig.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
