package lotto.model;

import static lotto.util.inputParser.convertStringToList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validateLotto(numbers);
        this.numbers = sortLottoNumber(numbers);
    }

    public Lotto(String input) { // winningLotto 생성자
        List<Number> parsedNumbers = parseStringInput(input);
        validateLotto(parsedNumbers);
        this.numbers = sortLottoNumber(parsedNumbers);
    }

    private List<Number> parseStringInput(String input) {
        List<Integer> rawWinningLotto = convertStringToList(input);
        return rawWinningLotto.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validateLotto(List<Number> numbers) {
        validateNumberSize(numbers);
        validateDuplicatedNumber(numbers);
    }

    private void validateNumberSize(List<Number> numbers) {
        if (isValidNumberSize(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isValidNumberSize(List<Number> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Number number : numbers) {
            if (hasDuplicatedNumber(uniqueNumbers, number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, Number number) {
        return !uniqueNumbers.add(number.getValue());
    }

    private List<Number> sortLottoNumber(List<Number> numbers) {
        List<Number> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort((n1, n2) -> Integer.compare(n1.getValue(), n2.getValue()));
        return sortedNumbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(number -> String.valueOf(number.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
