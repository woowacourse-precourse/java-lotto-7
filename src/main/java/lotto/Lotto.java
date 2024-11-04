package lotto;

import lotto.validator.LottoValidator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator lottoValidator = new LottoValidator(numbers);
        lottoValidator.validate();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

    }

    public void printLottoNumbers() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        List<Integer> sortedNumbers = numbers.stream().sorted().toList();
        for (int number : sortedNumbers) {
            result.append(number);
            result.append(", ");
        }
        result.append(numbers.get(numbers.size()-1));
        result.append("]");
        System.out.println(result);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
