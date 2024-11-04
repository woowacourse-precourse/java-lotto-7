package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateUnique(numbers);
        validateRange(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateUnique(List<Integer> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 허용되지 않습니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1 부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static List<Integer> createLotto() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
