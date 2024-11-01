package lotto;

import java.util.LinkedList;
import java.util.List;

public class WinningNumbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;
    private final int bonus;

    public WinningNumbers(List<Integer> winningNumber, int bonus) {
        if(isInvalidSize(winningNumber))
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");

        List<Integer> numberWithBonus = combine(winningNumber, bonus);
        if(hasDuplicatedNumbers(numberWithBonus))
            throw new IllegalArgumentException("당첨 번호와 bonus는 유니크해야 합니다.");
        if(hasNumbersOutOfRange(numberWithBonus))
            throw new IllegalArgumentException("당첨 번호와 bonus는 1~45 사이의 숫자여야 합니다.");

        this.numbers = winningNumber;
        this.bonus = bonus;
    }

    private LinkedList<Integer> combine(List<Integer> winningNumbers, int bonus) {
        LinkedList<Integer> numbers = new LinkedList<>(winningNumbers);
        numbers.add(bonus);
        return numbers;
    }

    private boolean hasNumbersOutOfRange(List<Integer> numbers) {
        return countNumbersInRange(numbers) != numbers.size();
    }

    private long countNumbersInRange(List<Integer> numbers) {
        return numbers.stream().filter(this::isWithinLottoRange).count();
    }

    private boolean isWithinLottoRange(Integer num) {
        return MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER;
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }

    private boolean hasDuplicatedNumbers(List<Integer> numbers) {
        return countUniqueNumber(numbers) != numbers.size();
    }

    private long countUniqueNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }
}
