package lotto.viewHandler.validator.validatorImpl;

import lotto.viewHandler.exception.NotLottoNumberSize;
import lotto.viewHandler.validator.Validator;

import java.util.List;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.viewHandler.exception.MyExceptionConstant.DELIMITER;
import static lotto.viewHandler.exception.MyExceptionConstant.NOT_WINNING_LOTTO_NUMBER_SIZE;


public class LottoNumberSplit implements Validator<List<String>, String> {
    @Override
    public List<String> validate(String input) {
        List<String> split = List.of(input.split(DELIMITER));
        if (split.size() != LOTTO_SIZE) {
            throw new NotLottoNumberSize(NOT_WINNING_LOTTO_NUMBER_SIZE);
        }
        return split;
    }
}
