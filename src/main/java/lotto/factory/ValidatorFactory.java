package lotto.factory;

import static lotto.factory.ValidatorType.BONUS_NUMBER;
import static lotto.factory.ValidatorType.PRICE;
import static lotto.factory.ValidatorType.WINNING_NUMBER;

import lotto.validator.BonusNumberValidator;
import lotto.validator.PriceValidator;
import lotto.validator.Validator;
import lotto.validator.WinningNumberValidator;

public class ValidatorFactory {

    public Validator create(ValidatorType type) {
        if (type == PRICE) {
            return new PriceValidator();
        }

        if (type == WINNING_NUMBER) {
            return new WinningNumberValidator();
        }

        if (type == BONUS_NUMBER) {
            return new BonusNumberValidator();
        }

        throw new IllegalStateException("[ERROR] 올바른 Validator 유형을 입력해주세요.");
    }
}
