package lotto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import java.util.List;

public class RandomSelector implements NumberSelector {

    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    @Override
    public List<Integer> selectNumbers() {
        return pickUniqueNumbersInRange(START, END, COUNT);
    }
}
