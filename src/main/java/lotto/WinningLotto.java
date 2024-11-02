package lotto;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        validate();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


    public void validate() {
        checkTotalCount();
        checkRange();
        checkDuplicate();
    }

    private void checkTotalCount() {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }

    private void checkRange() {
        numbers.stream().forEach(numbers -> validateRange(numbers));
        validateRange(bonusNumber);
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1부터 45사이여야 합니다.");
        }
    }

    private void checkDuplicate() {
        List<Integer> allNumbers = numbers;
        allNumbers.add(bonusNumber);
        if (allNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

}
