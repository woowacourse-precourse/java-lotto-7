package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import lotto.policy.LottoNumberPolicy;

public class LottoMachine {
    private static final int MIN = LottoNumberPolicy.MIN_NUMBER.number();
    private static final int MAX = LottoNumberPolicy.MAX_NUMBER.number();
    private static final int SCALE = LottoNumberPolicy.NUMBER_SCALE.number();

    public Lotto buyLotto() {
        return new Lotto(randomNumbers());
    }

    private List<Integer> randomNumbers() {
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange(MIN, MAX, SCALE);
//        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
