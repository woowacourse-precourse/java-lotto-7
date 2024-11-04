package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private Integer bonusNum;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validate2(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public void validate2(List<Integer> numbers) {
        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 번호가 중복되면 안됩니다.");
        }
    }

    public boolean checkDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public int bonusNumber(int number) {
        this.bonusNum = number;
        return bonusNum;
    }

    public List numbersList() {
        return numbers;
    }

}
