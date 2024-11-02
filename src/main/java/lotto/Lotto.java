package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.service.LottoGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }
        if(!areNumbersInRange(numbers)){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

    }

    // TODO: 추가 기능 구현

    private boolean areNumbersInRange(final List<Integer> numbers){
        return numbers.stream().allMatch(number -> 1 <= number && number <= 45);
    }

    private boolean hasDuplicates(final List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    public static Lotto generateLottoNumber() {
        List<Integer> generatedNumbers = LottoGenerator.generateLottoNumbers();
        return new Lotto(generatedNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
