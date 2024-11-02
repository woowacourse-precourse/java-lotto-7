package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException.throwIllegalArgumentException(ExceptionMessage.ONLY_LOTTO_SIZE_SIX, !validateLottoSize(numbers));
    }

    private boolean validateLottoSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }
}
