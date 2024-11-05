package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.common.LottoResults;

public class LottoContainer {
    private final List<Lotto> lotteries;

    public LottoContainer(final List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public int getSize() {
        return lotteries.size();
    }

    public Results verifyResults(final WinningLotto winningLotto) {
        final List<LottoResults> results = lotteries.stream()
                .map(lotto -> winningLotto.getResult(lotto))
                .collect(Collectors.toList());
        return new Results(results);
    }

    public List<LottoInfo> getInfos() {
        return lotteries.stream()
                .map(lotto -> new LottoInfo(lotto))
                .collect(Collectors.toList());
    }
}
