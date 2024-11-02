package lotto.domain;

import lotto.domain.exception.InvalidLottoNumberException;

record LottoNumber(int number) {
    private static final int MIN = 1;
    private static final int MAX = 45;

    LottoNumber {
        validate(number);
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            String message = String.format("숫자는 %d ~ %d 사이만 올 수 있습니다.", MIN, MAX);
            throw new InvalidLottoNumberException(message);
        }
    }
}
