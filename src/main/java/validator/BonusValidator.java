package validator;

import java.util.List;
import java.util.Objects;
import lotto.AbsoluteValue;
import lotto.ErrorMessage;

// 보너스와 당첨번호가 같으면 안 된다.
// 1~45 숫자는 사이여야 한다.
//
public class BonusValidator {
    public static void validate(Integer bonus, List<Integer> prizeNumber) {
        for(int i = 0; i< AbsoluteValue.LOTTO_NUMBER_COUNT; i+=1) {
            if(Objects.equals(bonus, prizeNumber.get(i))) {
                throw new IllegalArgumentException(ErrorMessage.BONUS_AND_PRIZE_NUMBER_DUPLICATION);
            }
        }
        if (bonus > AbsoluteValue.MAX_NUMBER || bonus < AbsoluteValue.MIN_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
