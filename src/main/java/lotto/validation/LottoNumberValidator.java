package lotto.validation;

import lotto.enums.Message;

import java.util.List;

public class LottoNumberValidator {

    private static final int LOTTO_SIZE = 6;

    public static void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(Message.ERROR_PREFIX.getMessage() + "로또 번호는 6개여야 합니다.");
        }
    }
}
