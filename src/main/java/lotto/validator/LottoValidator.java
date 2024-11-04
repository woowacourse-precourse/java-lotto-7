package lotto.validator;

import lotto.Lotto;
import lotto.constant.ErrorMessage;
import lotto.view.LottoView;

import java.util.List;
import java.util.Set;

import static lotto.constant.ErrorMessage.ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE;

public class LottoValidator {

    private List<Integer> numbers;

    public LottoValidator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void validate() {
        try {
            validateNumberIsNotDuplicated();
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateNumberIsNotDuplicated() {
        Set<Integer> lottoNumberSet = Set.copyOf(numbers);
        if (lottoNumberSet.size() != 6) {
            LottoView.printErrorMessage(ERROR_MESSAGE_FOR_WINNING_NUMBER_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }
}
