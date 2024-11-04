package lotto.service;

import lotto.domain.LottoIssue;
import lotto.domain.Lotto;
import lotto.strategy.IssueStrategy;

import static java.util.stream.LongStream.rangeClosed;

public class LottoIssueService {

    private final IssueStrategy issueStrategy;

    public LottoIssueService(IssueStrategy issueStrategy) {
        this.issueStrategy = issueStrategy;
    }

    public LottoIssue issue(long count) {
        return new LottoIssue(rangeClosed(1, count)
                .mapToObj(l -> issueStrategy.issue())
                .map(Lotto::new)
                .toList());
    }
}
