package lotto.validation;

import java.util.List;
import static lotto.constatnt.LottoConstants.LOTTO_NUMBER_SIZE;

public class LottoNumberValidator extends BaseValidator {

    public void validate(List<Integer> numbers) {
        checkSize(numbers, LOTTO_NUMBER_SIZE);
        checkDuplicates(numbers);
    }
}
