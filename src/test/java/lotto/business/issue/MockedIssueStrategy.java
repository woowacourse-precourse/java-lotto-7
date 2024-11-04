package lotto.business.issue;

import java.util.ArrayList;
import java.util.List;
import lotto.lotto.Lotto;
import lotto.lotto.LottoNumber;

public class MockedIssueStrategy implements IssueStrategy {
    public List<List<Integer>> lottoNumbers;

    public int issueCallCount = 0;

    public int issueManyLastCalledWith = 0;
    public int issueManyCallCount = 0;

    @Override
    public Lotto issue() {
        issueCallCount++;
        return new Lotto(lottoNumbers.removeFirst().stream().map(LottoNumber::new).toList());
    }

    @Override
    public List<Lotto> issueMany(int numOfLotto) {
        issueManyCallCount++;
        issueManyLastCalledWith = numOfLotto;

        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < numOfLotto; i++) {
            lotteries.add(issue());
        }
        return lotteries;
    }
}
