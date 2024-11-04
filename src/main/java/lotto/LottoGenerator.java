package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoGameInformation.LOTTO_MIN_NUMBER,
                LottoGameInformation.LOTTO_MAX_NUMBER, LottoGameInformation.LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
