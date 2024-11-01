package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLottoNumbers {

    public static final String NUMBERS_SIZE_ERROR_MESSAGE = "당첨 번호는 6개여야 합니다.";
    public static final String DUPLICATED_NUMBER_EXIST_ERROR_MESSAGE = "당첨 번호는 중복되지 않은 6개의 숫자여야 합니다.";

    private final List<LottoNumber> numbers;

    public WinningLottoNumbers(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public void validate(List<LottoNumber> numbers) {
        validateNumbersSize(numbers);
        validateNumbersDuplicate(numbers);
    }

    private void validateNumbersSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private void validateNumbersDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER_EXIST_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
