package lotto;

import java.util.List;

public class LottoValidator {

    private final String ERROR_LOG = "[ERROR] ";
    private final String INVALID_LOTTO_LENGTH = "로또 번호는 6개여야 합니다.";
    private final String DUPLICATE_LOTTO_NUMBER = "로또 번호는 중복값이 허용되지 않습니다.";

    public LottoValidator() {

    }

    public void validateLottoCreate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOG + INVALID_LOTTO_LENGTH);
        }
        numbers.stream()
                .distinct()
                .findFirst()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(ERROR_LOG + DUPLICATE_LOTTO_NUMBER);
                });
    }
}
