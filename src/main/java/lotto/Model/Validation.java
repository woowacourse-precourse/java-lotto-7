package lotto.Model;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public void purchaseValidator(int input) {
        if (input < 1000 || input % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 최소 금액은 1000원이고, 1000원 단위로만 구매할 수 있습니다.");
        }
    }

    public void bonusNumberValidator(int input) {
        validateRange(input);
    }

    public void winningNumberValidator(String[] setNumber) {
        validateNumberCount(setNumber);
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String number : setNumber) {
            int parsedNumber = parseAndValidateNumber(number);
            checkForDuplicate(uniqueNumbers, parsedNumber);
        }
    }

    private void validateNumberCount(String[] setNumber) {
        if (setNumber.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private int parseAndValidateNumber(String number) {
        try {
            int num = Integer.parseInt(number.trim());
            validateRange(num);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 모든 입력값은 숫자여야 합니다.");
        }
    }

    private void checkForDuplicate(Set<Integer> uniqueNumbers, int number) {
        if (!uniqueNumbers.add(number)) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
        }
    }

    private void validateRange(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }
}