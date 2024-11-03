package lotto.business.issue;

import java.util.List;
import lotto.lotto.Lotto;

public interface IssueStrategy {
    Lotto issue();

    List<Lotto> issueMany(int numOfLotto);
}
