package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public String getLottoNumbers() {
        return formatLottoNumber() + "\n";
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        checkNumberDuple(numbers);
        checkValidArrange(numbers);
    }

    private void checkValidArrange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 수만 가능합니다.");
            }
        }
    }

    private void checkNumberDuple(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 숫자가 중복되면 안됩니다.");
            }
            uniqueNumbers.add(number);
        }
    }

    private String formatLottoNumber() {
        sortLottoNumbers();
        return String.join(", ", Arrays.toString(numbers.toArray()));
    }

    private void sortLottoNumbers() {
        numbers.sort(Comparator.naturalOrder());
    }

}
