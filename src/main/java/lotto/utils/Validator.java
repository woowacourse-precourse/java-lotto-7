package lotto.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {
    // 1. 입력값이 비어있는지 검증
    private static void checkEmptyInput(String input, String errorMessage) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // 2. 숫자로만 이루어져 있는지 검증
    private static void checkNumericInput(String input, String errorMessage) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // 3. 음수 또는 0 금액인지 검증
    private static void checkPositiveAmount(int amount, String errorMessage) {
        if (amount <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // 4. 중복 검사: 당첨 번호가 중복되었는지 확인
    private static void checkDuplicateNumbers(String[] numbers, String errorMessage) {
        Set<String> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            if (!uniqueNumbers.add(number)) { // 중복이면 add가 false 반환
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }

    // 5. 번호 개수 확인
    private static void checkLottoNumbersLength(String[] numbers, String errorMessage) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    // 당첨 번호 중 보너스 번호 중복 검증
    public static void checkBonusNumberNotDuplicate(String bonusNumber, String[] winningNumbers) {
        for (String number : winningNumbers) {
            if (number.equals(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }
    }


    // 금앱 입력시 검증 로직
    public static void checkPurchaseAmount(String purchaseAmount) {
        // 유효성 검증
        checkEmptyInput(purchaseAmount, "구매 금액을 입력해주세요.");
        checkNumericInput(purchaseAmount, purchaseAmount + "은(는) 잘못된 입력입니다.");
        checkPositiveAmount(Integer.parseInt(purchaseAmount), "구매 금액은 0원 이상이어야 합니다.");
    }

    // 당첨 번호 입력 시 검증 로직
    public static void checkWinningLottoNumbers(String[] numbers, String errorMessage) {
        checkLottoNumbersLength(numbers, errorMessage);
        for (String number : numbers) {
            checkNumericInput(number, "잘못된 번호가 포함되어 있습니다.");
        }
    }

    // 보너스 번호 검증
    public static void checkBonusNumber(String bonusNumber, String[] numbers, String errorMessage) {
        checkEmptyInput(bonusNumber, errorMessage);
        checkNumericInput(bonusNumber, errorMessage);
        checkBonusNumberNotDuplicate(bonusNumber, numbers);
    }
}
