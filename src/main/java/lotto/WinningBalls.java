package lotto;

import java.util.List;

public class WinningBalls {

    private List<Integer> winningNumbers;

    public WinningBalls(List<Integer> winningNumbers) {
        long distinctNumber = winningNumbers.stream()
                .distinct()
                .count();
        if (distinctNumber != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }

        this.winningNumbers = winningNumbers;
    }

    public int getsize() {
        return winningNumbers.size();
    }

    public boolean isDistinct(int number) {
        long duplicatingCount = winningNumbers.stream()
                .filter(num -> num == number)
                .count();

        return duplicatingCount == 0;
    }

    public int getSameNumberCount(Lotto lotto) {
        return (int) this.winningNumbers.stream()
                .filter(lotto::hasNumber)
                .count();
    }
}
