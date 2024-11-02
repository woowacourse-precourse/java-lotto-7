package lotto;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.LottoResult;

public class LottoContainer {
    private final List<Lotto> lotteries;

    public LottoContainer(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public int getSize() {
        return lotteries.size();
    }

    public Results verifyResults(final WinningLotto winningLotto) {
        final List<LottoResult> results = lotteries.stream()
                .map(lotto -> winningLotto.getResult(lotto))
                .collect(Collectors.toList());
        return new Results(results);
    }
}
