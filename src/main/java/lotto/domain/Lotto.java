package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateEachNumber(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto createLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public String printLotto() {
        String joinNumbers = String.join(", ", numbers.stream()
            .map(String::valueOf)
            .toList());
        return "[" + joinNumbers + "]";
    }

    public LottoPrize calculatePrize(LottoWinningNumbers lottoWinningNumbers) {
        int winningCount = 0;
        int bonusCount = 0;
        for (Integer number : numbers) {
            if (lottoWinningNumbers.getWinningNumbers().contains(number)) {
                winningCount++;
            }
            if (number == lottoWinningNumbers.getBonusWinningNumber()) {
                bonusCount++;
            }
        }
        return matchPrize(winningCount, bonusCount);
    }

    private LottoPrize matchPrize(int winningCount, int bonusCount) {
        if (winningCount == 6) return LottoPrize.FIRST_PRIZE;
        if (winningCount == 5 && bonusCount == 1) return LottoPrize.SECOND_PRIZE;
        if (winningCount == 5) return LottoPrize.THIRD_PRIZE;
        if (winningCount == 4) return LottoPrize.FOURTH_PRIZE;
        if (winningCount == 3) return LottoPrize.FIFTH_PRIZE;
        return LottoPrize.NO_PRIZE;
    }


    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateEachNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복일 수 없습니다.");
        }
    }
}
