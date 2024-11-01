package lotto.model;

import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.service.PolicyService;

public class LottoNumberGenerator {
    private final PolicyService policyService;

    public LottoNumberGenerator(PolicyService policyService) {
        this.policyService = policyService;
    }

    public List<Integer> generate() {
        List<Integer> numbers =  Randoms.pickUniqueNumbersInRange
                (policyService.getLottoMinNumber(), policyService.getLottoMaxNumber(), policyService.getLottoNumberScale());
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
}
