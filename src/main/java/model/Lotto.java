package model;

import java.util.List;
import java.util.stream.Collectors;

import validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto() {
        numbers = LottoGenerator.generateLotto().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> numbers) {

        LottoValidator.isUniqueNumbers(numbers);
        LottoValidator.hasSixElements(numbers);

        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        ;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
