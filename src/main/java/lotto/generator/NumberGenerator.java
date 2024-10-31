package lotto.generator;

import static lotto.model.LottoRule.MAX_NUMBER;
import static lotto.model.LottoRule.MIN_NUMBER;
import static lotto.model.LottoRule.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public enum NumberGenerator {
    RANDOM {
        public List<Integer> generateNumber() {
            return Randoms.pickUniqueNumbersInRange(
                    MIN_NUMBER.getConstant(),
                    MAX_NUMBER.getConstant(),
                    NUMBER_COUNT.getConstant());
        }
    };

    public abstract List<Integer> generateNumber();
}
