package lotto.validator;

import java.util.List;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static void validateNumberCount(List<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
    }
}
