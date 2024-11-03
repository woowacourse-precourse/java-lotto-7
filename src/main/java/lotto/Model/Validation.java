package lotto.Model;

import static lotto.Model.ErrorCode.*;
import static lotto.constants.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    //로또 구매로직 검증기
    public void purchaseValidator(int input) {
        if (input < LOTTO_PRICE || input % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PURCHASE_AMOUNT.getMessage());
        }

    }

    //보너스숫자 검증메소드
    public void bonusNumberValidator(int input) {
        validateRange(input);
    }

    //당첨 숫자 검증메소드
    public void winningNumberValidator(String[] setNumber) {
        validateNumberCount(setNumber);
        validateNoDuplicates(setNumber);
        Arrays.stream(setNumber).forEach(number ->
                validateRange(Integer.parseInt(number)));
    }

    //보너스 넘버가 당첨번호와 중복되는지 검증 메소드
    public void isWinningNumberContainBonus(ArrayList<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    //로또 번호가 6자리인지 검증하는 매소드
    private void validateNumberCount(String[] setNumber) {
        if (setNumber.length != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    //중복을 체크하는 메소드
    private void validateNoDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(List.of(numbers));
        if (uniqueNumbers.size() != numbers.length) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    //로또 숫자가 1~45인지 검증하는 메소드
    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}