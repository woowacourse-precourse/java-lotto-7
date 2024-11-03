package lotto.model.lotto;

import static lotto.model.util.constant.LottoConstants.LOTTO_SIZE;
import static lotto.model.util.constant.LottoConstants.MAX_NUMBER;
import static lotto.model.util.constant.LottoConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator {

    public Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(numbers);
    }

}
