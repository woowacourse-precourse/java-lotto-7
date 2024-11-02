package lotto.numberSelector;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.LottoShop.*;

import java.util.List;

public class RandomSelector implements NumberSelector {

    @Override
    public List<Integer> selectNumbers() {
        return pickUniqueNumbersInRange(START, END, COUNT);
    }
}
