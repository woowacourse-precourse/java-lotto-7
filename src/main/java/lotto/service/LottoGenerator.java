package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerator {
    public Lotto generateByNums(List<Integer> nums) {
        return new Lotto(nums);
    }

    public Lotto generateByRandom() {
        List<Integer> nums = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(nums);
        Lotto lotto = generateByNums(nums);
        return lotto;
    }
}
