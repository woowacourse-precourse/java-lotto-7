package lotto.service;

import java.util.List;
import lotto.enums.ErrorMessage;

public class ValidateService {

    public boolean validateRangeLottoNumbers (List<Integer> numbers) {
        // 1 ~ 45 사이 수 체크
        for (int num: numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
            }
        }
        return true;
    }

    public boolean validateDuplicateLottoNumbers (List<Integer> numbers) {
        // 중복 수 체크
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

        return true;
    }

    public boolean validateMoney (int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY_INPUT_1000.getMessage());
        }
        return true;
    }

    public boolean validateBonus (int bonusNum) {
        if (bonusNum < 1 || bonusNum > 45) {
            return false;
        }
        return true;
    }

}
