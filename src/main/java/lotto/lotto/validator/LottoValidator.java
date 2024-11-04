package lotto.lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;
import lotto.lotto.domain.BonusNumber;
import lotto.lotto.domain.WinningLotto;

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

    private static boolean isNotContainDuplicate(List<Integer> numbers) {
        Set<Integer> exceptedDuplicate = new HashSet<>(numbers);
        return numbers.size() != exceptedDuplicate.size();
    }

    private static boolean isWithinRange(int number) {
        int minNumberRange = LottoConstant.MIN_LOTTO_NUMBER_RANGE.getValue();
        int maxNumberRange = LottoConstant.MAX_LOTTO_NUMBER_RANGE.getValue();
        return number < minNumberRange || number > maxNumberRange;
    }

    private static void isDuplicateValidate(BonusNumber bonusNumber, WinningLotto winningLotto) {
        if (winningLotto.isContain(bonusNumber.getNumber())) ErrorMessage.DUPLICATE.throwIllegalArgumentException();
    }

    private static void isNumberCountValidate(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT.getValue()) {
            ErrorMessage.NUMBER_COUNT.throwIllegalArgumentException();
        }
    }

    private static void isWithinRangeValidate(BonusNumber bonusNumber) {
        boolean outOfRange = isWithinRange(bonusNumber.getNumber());
        if (outOfRange) ErrorMessage.WITHIN_RANGE.throwIllegalArgumentException();
    }

    private static void isWithinRangeValidate(List<Integer> numbers) {
        boolean outOfRange = numbers.stream().anyMatch(LottoValidator::isWithinRange);
        if (outOfRange) ErrorMessage.WITHIN_RANGE.throwIllegalArgumentException();
    }

    private static void isDuplicateValidate(List<Integer> numbers) {
        if (isNotContainDuplicate(numbers)) ErrorMessage.DUPLICATE.throwIllegalArgumentException();
    }
}
