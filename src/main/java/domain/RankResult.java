package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankResult {

    private final Map<WinningLotto, Long> rankResult;

    public RankResult(List<WinningLotto> winningLottos) {
        this.rankResult = winningLottos.stream()
                .collect(Collectors.groupingBy(winningLotto -> winningLotto, Collectors.counting()));
    }

    public Map<WinningLotto, Long> getRankResult() {
        return this.rankResult;
    }


}
