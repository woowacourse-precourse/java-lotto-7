package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicate(numbers);
        this.numbers = numbers;
    }

    // 중복된 숫자인지 확인하는 거 필요하다.
    // 보너스 번호 중복인지 확인 필요하다.
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복됩니다.");
        }
        return true;
    }

    public void bonusValidate(int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 기존 번호와 보너스 번호가 중복된니다.");
        }
    }

    public List<Integer> getWinNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
