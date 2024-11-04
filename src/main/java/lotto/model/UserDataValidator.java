package lotto.model;

import lotto.common.utils.ValidationUtils;

import java.util.List;

public class UserDataValidator {

    public static void validateWinNumbers(List<Integer> winNumbers){
        ValidationUtils.validateNumberSize(winNumbers.size());
        ValidationUtils.validateDuplicateWinNumber(winNumbers);
    }

    public static void validateBonusNumber(List<Integer> winNumbers, int bonusNumber){
        ValidationUtils.validateNumberRange(bonusNumber);
        ValidationUtils.validateDuplicateBonusNumber(winNumbers, bonusNumber);
    }

    public static void validateMoney(int money){
        ValidationUtils.validateNotUsedNumber(money);
        ValidationUtils.validateUnit(money);
    }

}
