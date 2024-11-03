package lotto.policy;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.function.Supplier;

import static lotto.constants.LottoConstants.*;

public enum LottoNumberPolicy {

    RANDOM_NUMBERS(() -> Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, COUNT_NUMBER));

    private final Supplier<List<Integer>> policy;

    LottoNumberPolicy(Supplier<List<Integer>> policy) {
        this.policy = policy;
    }

    public List<Integer> getNumbers() {
        return policy.get();
    }
}
