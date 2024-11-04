package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumberRange(numbers);
        validateUniqueNumbers(numbers);
        this.numbers = sortList(numbers);
    }

    public int getIndex(int numbers) {
        return this.numbers.get(numbers);
    }

    public boolean matchNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> sortList(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        sortedList.sort(Integer::compareTo);
        return sortedList;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException("[ERROR] 번호는 1~45사이의 숫자여야 합니다.");
            }
        }
    }

    public void validateUniqueNumbers(List<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            int currentNumber = numbers.get(i);
            for (int j = 0; j < 6; j++) {
                if (i != j && numbers.get(j).equals(currentNumber)) {
                    throw new IllegalArgumentException("입력된 숫자가 중복되었습니다.");
                }
            }
        }
    }
}
