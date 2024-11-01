package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {
    private final int LOTTO_SIZE = LottoGameInformation.LOTTO_SIZE.getValue();
    private final int LOTTO_MIN_NUMBER = LottoGameInformation.LOTTO_MIN_NUMBER.getValue();
    private final int LOTTO_MAX_NUMBER = LottoGameInformation.LOTTO_MAX_NUMBER.getValue();

    public Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
