package lotto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoEnum;
import lotto.utils.Utils;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.IVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
        if (!Utils.isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
        List<BigDecimal> numbersBig = numbers.stream().map(number -> new BigDecimal(number)).toList();
        BigDecimal bigmin = new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber());
        BigDecimal bigmax = new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber());
        if (!Utils.areAllNumbersValidRange(bigmin, bigmax, numbersBig)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
        if (!Utils.isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // TODO: 추가 기능 구현
}