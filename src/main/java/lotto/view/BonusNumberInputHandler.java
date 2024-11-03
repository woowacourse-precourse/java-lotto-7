package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class BonusNumberInputHandler {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private BonusNumberInputHandler() {
    }

    public static int promptGetBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();
                return validateBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateBonusNumber(String input) {
        int bonusNumber = validateBonusNumberIsInteger(input);
        validateBonusNumberRange(bonusNumber);
        return bonusNumber;
    }

    public static int validateBonusNumberIsInteger(String input) {
        if (input.contains(".")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 숫자는 정수여야 합니다.");
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException((ERROR_MESSAGE + " 보너스 숫자는 정수여야 합니다."));
        }
    }

    public static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 숫자는 1에서 45 사이의 값이어야 합니다.");
        }
    }
}
