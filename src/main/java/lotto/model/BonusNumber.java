package lotto.model;

import lotto.exception.BonusNumberException;
import lotto.validation.BonusNumberValidator;

import static lotto.common.constant.ErrorMessage.BONUS_NUMBER_FORMAT_ERROR;

public class BonusNumber {

    private final Integer bonusNumber;

    private BonusNumber(String userInputBonusNumber) {
        this.bonusNumber = parseUserInputBonusNumber(userInputBonusNumber);
    }

    public static BonusNumber of(String userInputBonusNumber){
        return new BonusNumber(userInputBonusNumber);
    }

    private Integer parseUserInputBonusNumber(String userInputBonusNumber){
        Integer bonusNumber;
        try{
            bonusNumber = Integer.parseInt(userInputBonusNumber);
        }catch(NumberFormatException e){
            throw new BonusNumberException(BONUS_NUMBER_FORMAT_ERROR);
        }

        BonusNumberValidator.validateBonusNumber(bonusNumber);
        return bonusNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
