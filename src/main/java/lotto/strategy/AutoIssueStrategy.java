package lotto.strategy;

import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumberRange.MAX;
import static lotto.domain.LottoNumberRange.MIN;

public class AutoIssueStrategy implements IssueStrategy {

    private static AutoIssueStrategy instance;

    private AutoIssueStrategy() {}

    public static AutoIssueStrategy getInstance() {
        if (instance == null) {
            instance = new AutoIssueStrategy();
        }

        return instance;
    }

    @Override
    public List<Integer> issue() {
        return pickUniqueNumbersInRange(MIN.getValue(), MAX.getValue(), LOTTO_SIZE);
    }
}
