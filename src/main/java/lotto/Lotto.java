package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public Lotto(String numbers) throws IllegalArgumentException {
        this(Arrays.asList(numbers.split(","))
                .stream()
                .mapToInt(it -> Integer.parseInt(it))
                .boxed()
                .collect(Collectors.toList()));
    }

    private void validateNumberCount(List<Integer> numbers) throws IllegalArgumentException{
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

    }

    private void validateNumberRange(List<Integer> numbers) throws IllegalArgumentException {
        if (existOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자는 1에서 45 사이여야 합니다.");
        }
    }

    private boolean existOutOfRangeNumber(List<Integer> numbers) {
        return !numbers.stream()
                .filter(it -> (it < 1 || it > 45))
                .collect(Collectors.toList())
                .isEmpty();
    }

    private void validateDuplicatedNumber(List<Integer> numbers) throws IllegalArgumentException {
        if (existDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자가 중복되면 안됩니다.");
        }
    }

    private boolean existDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
