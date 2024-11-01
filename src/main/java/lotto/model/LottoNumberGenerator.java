package lotto.model;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.policy.LottoNumberPolicy;
import lotto.policy.LottoNumberScalePolicy;
import lotto.service.PolicyService;

public class LottoNumberGenerator {
    private PolicyService policyService;

    public LottoNumberGenerator(PolicyService policyService) {
        this.policyService = policyService;
    }

//    public List<Integer> generateNumbers() {
//        return Randoms.pickUniqueNumbersInRange
//                (LottoNumberPolicy.MIN_NUMBER.number());
//    }
}
