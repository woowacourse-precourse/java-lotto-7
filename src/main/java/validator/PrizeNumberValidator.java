package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.AbsoluteValue;
import lotto.ErrorMessage;

// PrizeNumber의 값 유효성을 검증하는 클래스
// 1. 로또 번호(1-45) 사이인가 o
// 2. 중복되는 수가 없는가 o
// 3. 당첨번호 수가 6개로 일치하는가. o
// 4. 기본적인 null-check. => 항상 false로 되기 때문에 제외함
// + 변하지 않는 값(최대값, 최소값 등)은 상수로 정의할 것
public class PrizeNumberValidator {
    public static void validate (List<Integer> numbers) {
        for(Integer number : numbers) {
            if (number < AbsoluteValue.MIN_NUMBER || number > AbsoluteValue.MAX_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_OUT_OF_RANGE);
            }
        }

        if (numbers.size() != AbsoluteValue.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.PRIZE_COUNT_OUT_OF_SIX);
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException(ErrorMessage.PRIZE_NUMBER_DUPLICATION);
        }
    }
}
