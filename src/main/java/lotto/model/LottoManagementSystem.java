package lotto.model;

import java.util.List;

public class LottoManagementSystem {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoManagementSystem(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void recordRank(List<Integer> numbers){

    }

    private int returnRank(List<Integer> numbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }

        return checkRank(numbers, matchCount);
    }

    private int checkRank(List<Integer> numbers, int matchCount) {
        return switch (matchCount) {
            case 6 -> 1;
            case 5 -> {
                if (numbers.contains(bonusNumber)) {
                    yield 2;
                }
                yield 3;
            }
            case 4 -> 4;
            case 3 -> 5;
            default -> 6;
        };
    }

}
