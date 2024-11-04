package lotto.generator;

import static lotto.model.constant.LottoRule.MAX_NUMBER;
import static lotto.model.constant.LottoRule.MIN_NUMBER;
import static lotto.model.constant.LottoRule.NUMBER_COUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public enum NumberGenerator {
    RANDOM {
        @Override
        public List<Integer> generateNumber() {
            return Randoms.pickUniqueNumbersInRange(
                    MIN_NUMBER.getConstant(),
                    MAX_NUMBER.getConstant(),
                    NUMBER_COUNT.getConstant());
        }
    };

    public abstract List<Integer> generateNumber();
}
