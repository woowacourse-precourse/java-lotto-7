package lotto.domain.model;

import lotto.common.exception.BusinessException;
import lotto.common.exception.ErrorCode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.constant.PrintFormatConst.*;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create(List<Integer> numbers) {
        return new Lotto(numbers);
    }


    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new BusinessException(ErrorCode.LOTTO_INVALID_QUANTITY);
        }
        int size = numbers.stream().distinct().toList().size();
        if (size != numbers.size()) {
            throw new BusinessException(ErrorCode.LOTTO_INVALID_QUANTITY);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public String print() {
        return String.format(LOTTO_NUMBERS_FORMAT,
                numbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "))
        );
    }

}
