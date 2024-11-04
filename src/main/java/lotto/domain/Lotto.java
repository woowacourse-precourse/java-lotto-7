package lotto.domain;

import lotto.util.NumberSorter;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;
    private WinningState winningState;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (!numbers.stream().allMatch(this::validateNumberRange)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public boolean validateNumberRange(int number) {
        return 1 <= number && number <= 45;
    }

    public String checkWinner(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> commonList = new ArrayList<>(numbers);
        commonList.retainAll(winningNumbers);
        if (commonList.size() == 6) {
            return "FIRST_PRIZE";
        }
        winningNumbers.add(bonusNumber);
        return checkPrize(winningNumbers);
    }
    public String checkPrize(List<Integer> winningNumbers) {
        List<Integer> commonList = new ArrayList<>(numbers);
        commonList.retainAll(winningNumbers);
        if (commonList.size() == 6) {
            return "SECOND_PRIZE";
        }
        if (commonList.size() == 5) {
            return "THIRD_PRIZE";
        }
        if (commonList.size() == 4) {
            return "FOURTH_PRIZE";
        }
        if (commonList.size() == 3) {
            return "FIFTH_PRIZE";
        }
        return "NO_LUCK";
    }

    @Override
    public String toString() {
        return NumberSorter.sort(numbers).toString();
    }
}
