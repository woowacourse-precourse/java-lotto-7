package lotto.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumberGenerator {
    private LottoPolicy policy;

    public LottoNumberGenerator(LottoPolicy policy) {
        this.policy = policy;
    }

    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange
                (policy.minimumNumber(),policy.maximumNumber(),policy.lottoCompositionScale());
    }
}
