package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WinningNumbers {
    private static final int COUNTS_OF_LOTTO = 6;
    private static final int MAX_VALUE_OF_LOTTO = 45;
    private static final int MIN_VALUE_OF_LOTTO = 1;

    private final List<Integer> numbers = new ArrayList<>();

    public WinningNumbers(List<String> numbers) throws IllegalArgumentException {
        validate(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            this.numbers.add(Integer.parseInt(numbers.get(i)));
        }
    }

    private void validate(List<String> numbers) {
        isSizeSix(numbers);
        isDuplicate(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            isBlank(numbers.get(i));
            isNotNumber(numbers.get(i));
            isOutOfBound(Integer.parseInt(numbers.get(i)));
        }
    }

    private void isDuplicate(List<String> numbers) {
        HashSet<String> duplicateCheck = new HashSet<>(numbers);
        if (duplicateCheck.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호는 중복될 수 없습니다.");
        }
    }

    private void isSizeSix(List<String> numbers) {
        if (numbers.size() != COUNTS_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void isNotNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private void isBlank(String number) {
        if (number.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private void isOutOfBound(int number) {
        if (number < MIN_VALUE_OF_LOTTO || number > MAX_VALUE_OF_LOTTO) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 수를 입력해 주세요.");
        }
    }

    public boolean contains(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.number());
    }

    public int numberAt(int index) {
        return numbers.get(index);
    }
}
