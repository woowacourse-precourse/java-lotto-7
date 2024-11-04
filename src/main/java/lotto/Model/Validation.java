package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constants.Constants;

public class Validation {
    // 로또 구매 로직 검증기
    public void purchaseValidator(int input) {
        if (input < Constants.LOTTO_PRICE || input % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    // 보너스 숫자 검증 메소드
    public void bonusNumberValidator(int input) {
        validateRange(input);
    }

    // 당첨 숫자 검증 메소드
    public void winningNumberValidator(String[] setNumber) {
        validateNumberCount(setNumber.length);
        validateNoDuplicates(setNumber);
        for (String number : setNumber) {
            validateRange(Integer.parseInt(number));
        }
    }

    // 보너스 넘버와 당첨 번호의 중복 체크
    public void validateBonusNumberWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        isWinningNumberContainBonus(winningNumbers, bonusNumber);
    }

    // 보너스 넘버가 당첨번호와 중복되는지 검증 메소드
    public void isWinningNumberContainBonus(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
    //로또가 6자리인지 검증하는 메서드
    private void validateNumberCount(int count) {
        if (count != Constants.LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }
    //중복여부를 판단하는 메서드
    private void validateNoDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(List.of(numbers));
        if (uniqueNumbers.size() != numbers.length) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }
    //로또의 숫자 범위 검증 메소드
    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(ErrorCode.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
