package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void setBonusNumber(int bonusNumber) {
        validateDuplicate(bonusNumber);
        validateRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public String toString() {
        String string = "[" + numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            string += ", " + numbers.get(i);
        }
        string += "]";
        return string;
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int n : numbers) {
            set.add(n);
        }
        if (set.size() < 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 중복입니다.");
        }
    }

    private void validateDuplicate(int bonus) {
        Set<Integer> set = new HashSet<>();
        for (int n : this.numbers) {
            set.add(n);
        }
        set.add(bonus);
        if (set.size() < 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 중복입니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n > 45 || n < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호 범위는 1~45 입니다.");
            }
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호 범위는 1~45 입니다.");
        }
    }
}
