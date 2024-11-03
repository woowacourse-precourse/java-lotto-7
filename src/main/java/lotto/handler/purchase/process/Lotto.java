package lotto.handler.purchase.process;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public String getDisplayNumbers() {
        return numbers.toString();
    }

    public WinningRank getRank(List<Integer> winningNumbers, int bonusNumber) {
        int sameNumberCount = (int) numbers.stream().filter(number -> winningNumbers.stream()
                .anyMatch(winningNumber -> isSameNumber(winningNumber, number))).count();
        if (sameNumberCount == 5) {
            return getSecondOrThirdRank(numbers, bonusNumber);
        }
        return getRank(sameNumberCount);
    }

    private WinningRank getRank(int sameNumberCount) {
        if (isFirstRank(sameNumberCount)) {
            return WinningRank.FIRST;
        }
        if (isFourthRank(sameNumberCount)) {
            return WinningRank.FOURTH;
        }
        if (isFifthRank(sameNumberCount)) {
            return WinningRank.FIFTH;
        }
        return WinningRank.LOSE;
    }

    private WinningRank getSecondOrThirdRank(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return WinningRank.SECOND;
        }
        return WinningRank.THIRD;
    }

    private boolean isFirstRank(int sameNumberCount) {
        return sameNumberCount == 6;
    }

    private boolean isFourthRank(int sameNumberCount) {
        return sameNumberCount == 4;
    }

    private boolean isFifthRank(int sameNumberCount) {
        return sameNumberCount == 3;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isSameNumber(int winningNumber, int number) {
        return winningNumber == number;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
