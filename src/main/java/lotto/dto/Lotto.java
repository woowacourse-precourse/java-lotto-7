package lotto.dto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateNumberRanges(numbers);
        validateUniqueNumber(numbers);
    }
    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 번호로 이루어져 있습니다.");
        }
    }
    private void validateUniqueNumber(List<Integer> numbers) {
        List<Integer> uniqueNumbers = numbers.stream().distinct().toList();
        if(!numbers.equals(uniqueNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복되는 숫자가 존재합니다.");
        }
    }
    private void validateNumberRanges(List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }
    private void validateNumberRange(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER)
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45사이의 값이여야 합니다.");
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
