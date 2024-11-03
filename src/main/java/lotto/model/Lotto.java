package lotto.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoEnum;
import lotto.utils.Utils;
import lotto.validation.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        List<BigDecimal> numbersBigType = numbers.stream().map(number -> new BigDecimal(number)).toList();
        BigDecimal minBigType = new BigDecimal(LottoEnum.MIN_LOTTO_RANGE.getNumber());
        BigDecimal maxBigType = new BigDecimal(LottoEnum.MAX_LOTTO_RANGE.getNumber());

        Validator.checkLottoLength(numbers.size());
        Validator.DuplicateNumber(numbersBigType);
        Validator.allNumberRange(
                minBigType,
                maxBigType,
                numbersBigType);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}