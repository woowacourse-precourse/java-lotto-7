package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Predicate;

public class LottoMachine {

    public static Lotto releaseLotto(RandomIntegersGenerator randomGenerator) {
        return new Lotto(randomGenerator.generate());
    }
}
