package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.error.ErrorType;
import lotto.view.error.InputErrorException;

public class Lotto {

    public static final String NEED_SIX_NUMBERS = "로또 번호는 6개여야 합니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkIfEmpty(numbers);
        checkLottoNumberCount(numbers);
        hasDuplicate(numbers);
    }

    private void checkLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new InputErrorException(NEED_SIX_NUMBERS);
        }
    }

    private void hasDuplicate(List<Integer> numbers) {

        Set<Integer> distinctLottoNumbers = new HashSet<>();

        for (Integer lottoNumber : numbers) {
            if (!distinctLottoNumbers.add(lottoNumber)) {
                throw new InputErrorException(ErrorType.NEED_DISTINCT_NUMBER);
            }
        }
    }

    private void checkIfEmpty(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new InputErrorException(ErrorType.NEED_NOT_EMPTY);
        }
    }
}
