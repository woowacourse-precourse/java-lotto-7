package lotto.service;

import static lotto.common.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import lotto.model.Lotto;

public class LottoBonusDuplicateCheckerService {
    public static void checkForDuplicates(Lotto lotto, int bonusNumber){
        if(lotto.getNumbers().contains(bonusNumber)){
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.format());
        }
    }

}
