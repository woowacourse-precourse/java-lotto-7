package lotto.domain;

import lotto.strategy.IssueStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class UserLotto {

    private final LottoPurchase purchase;
    private final List<Lotto> lottos;

    public UserLotto(LottoPurchase purchase, IssueStrategy issueStrategy) {
        this.purchase = purchase;
        this.lottos = issueLottos(issueStrategy, purchase.getCount());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public LottoPurchase getPurchase() {
        return purchase;
    }

    private List<Lotto> issueLottos(IssueStrategy issueStrategy, long count) {
        return LongStream.rangeClosed(1, count)
                .mapToObj(l -> issueStrategy.issue())
                .map(Lotto::new)
                .toList();
    }
}
