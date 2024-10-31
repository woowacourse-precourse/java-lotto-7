package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = createLotto(numbers);
    }

    public List<Number> displayLotto() {
        return Collections.unmodifiableList(numbers);
    }

    private List<Number> createLotto(List<Integer> numbers) {
        List<Number> lottoNumber = new ArrayList<>();

        for(int number : numbers) {
            lottoNumber.add(Number.from(number));
        }

        return lottoNumber;
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_LOTTO_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> lottoNumbers = new HashSet<>(numbers);

        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new CustomException(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
