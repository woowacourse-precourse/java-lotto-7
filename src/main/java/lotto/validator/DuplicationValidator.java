package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ErrorMessage;

public class DuplicationValidator {
    public static void validate(List<Integer> number) {
        Set<Integer> numbers = new HashSet<>(number);
        if (numbers.size() != number.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_WIN_NUMBER.getMessage());
        }
    }
}