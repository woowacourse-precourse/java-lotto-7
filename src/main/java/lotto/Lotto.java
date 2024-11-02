package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberLengthIsSix(numbers);
        validateLottoNumberIsDuplicate(numbers);
    }

    private void validateLottoNumberLengthIsSix(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateLottoNumberIsDuplicate(List<Integer> numbers) {
        Set<Integer> checkDuplicates = new HashSet<>(numbers);
        if(checkDuplicates.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 겹치지 않아야 합니다.");
        }
    }

    public Integer howManyMatches(Lotto lotto) {
        Integer count = 0;
        for (Integer number : numbers) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public static Lotto generateWinningNumber(String input, String delimiter) {
         List<Integer> numbers = Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
         return new Lotto(numbers);
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.stream().sorted().toArray());
    }
}
