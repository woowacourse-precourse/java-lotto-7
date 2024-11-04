package lotto.domain.validator;

import java.util.List;

public interface InputValidator {
    void validate(String input);

    void validate(List<Integer> numbers);
}

