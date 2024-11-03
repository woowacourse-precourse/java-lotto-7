package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberInRange(numbers);
        checkForDuplicateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 값을 입력해주세요.");
            }
        }
    }

    public void checkForDuplicateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            isDuplicateInLottoNumbers(numbers, number);
        }

    }

    public void isDuplicateInLottoNumbers(List<Integer> numbers, Integer input) {
        int count = 0;
        for (Integer number : numbers) {
            if (input.equals(number)) {
                count++;
            }
        }
        if (count > 1) {
            throw new IllegalArgumentException("[ERROR] 중복된 값 입니다.");
        }
    }
    public int lottoSize() {
        return numbers.size();
    }
    public int getNumber(int num) {
        return numbers.get(num);
    }
}
