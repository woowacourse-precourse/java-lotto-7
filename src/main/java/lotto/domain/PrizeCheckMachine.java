package lotto.domain;

import java.util.List;

public class PrizeCheckMachine implements CriteriaTool {

    private final List<Integer> winningNumbers;
    private final Integer luckyNumber;

    public PrizeCheckMachine(List<Integer> winningNumbers, Integer luckyNumber) {
        this.winningNumbers = winningNumbers;
        this.luckyNumber = luckyNumber;
    }

    @Override
    public Long matchingMainNumbers(List<Integer> lotto) {
        return lotto.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public Boolean matchingLuckyNumber(List<Integer> lotto) {
        return null;
    }
}
