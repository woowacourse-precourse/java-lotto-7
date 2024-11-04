package lotto;

import java.util.List;

public class LottoSummary {

    public LottoSummary() {

    }

    public double summary(int money, List<WinningType> winningTypes) {
        int income = winningTypes.stream()
                .map(winningType -> winningType.getPrize())
                .mapToInt(Integer::intValue)
                .sum();
        return (double) income / money;
    }
}
