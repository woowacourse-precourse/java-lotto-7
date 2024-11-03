package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LotteryVendor {

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public LotteryVendor(List<List<Integer>> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos.stream().map(Lotto::new).toList();
        this.winningNumber = new WinningNumber(winningNumbers, bonusNumber);
    }

    public Result calculateResult() {
        List<Rank> results = lottos.stream()
                .map(lotto -> lotto.countRank(winningNumber.getNumbers(), winningNumber.getBonusNumber()))
                .collect(Collectors.toList());
        return new Result(results);
    }
}
