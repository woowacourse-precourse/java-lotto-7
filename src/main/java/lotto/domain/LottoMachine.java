package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoMachine {

    private List<Prize> prizes;

    private Lotto generateRandomLotto() {
        List<Integer> numbers =
                Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER, Lotto.LOTTO_SIZE);
        return Lotto.from(numbers);
    }
}
