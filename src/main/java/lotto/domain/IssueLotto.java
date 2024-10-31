package lotto.domain;

import lotto.strategy.IssueStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class IssueLotto {

    private final List<Lotto> lottos;

    public IssueLotto(long buyCount, IssueStrategy issueStrategy) {
        this.lottos = issue(buyCount, issueStrategy);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    private List<Lotto> issue(long buyCount, IssueStrategy issueStrategy) {
        return LongStream.rangeClosed(1, buyCount)
                .mapToObj(l -> issueStrategy.issue())
                .map(Lotto::new)
                .toList();
    }
}
