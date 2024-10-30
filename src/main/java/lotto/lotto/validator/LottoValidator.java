package lotto.lotto.validator;

import lotto.constant.LottoConstant;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {

    public static void lottoValidate(List<Integer> numbers) {
        isNumberCountValidate(numbers);
        isWithinRangeValidate(numbers);
        isDuplicateValidate(numbers);
    }

    public static void bonusNumberValidate(BonusNumber bonusNumber, WinningLotto winningLotto) {
        isDuplicateValidate(bonusNumber, winningLotto);
        isWithinRangeValidate(bonusNumber);
    }

    private static void isDuplicateValidate(BonusNumber bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.isContain(bonusNumber.getNumber()))
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
    }

    private static void isNumberCountValidate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void isWithinRangeValidate(BonusNumber bonusNumber) {
        boolean outOfRange = isWithinRange(bonusNumber.getNumber());
        if (outOfRange) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    private static void isWithinRangeValidate(List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(LottoValidator::isWithinRange);
        if (outOfRange) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    private static void isDuplicateValidate(List<Integer> numbers) {
        Set<Integer> exceptedDuplicate = new HashSet<>(numbers);
        if (numbers.size() != exceptedDuplicate.size()) throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");

    }

    private static boolean isWithinRange(int number) {
        int minNumberRange = LottoConstant.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoConstant.MAX_LOTTO_NUMBER_RANGE.getValue();
        return number < minNumberRange || number > maxNumberRange;
    }


/*
  - [ ] 1 ~ 45까지 범위의 중복되지 않은 랜덤한 번호 6개를 생성한다.
  - [ ] 중복된 수가 있을 경우
  - [x] 6개의 수로 이뤄지지 않았을 경우

 */
}
