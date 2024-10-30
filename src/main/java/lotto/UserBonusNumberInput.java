package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserBonusNumberInput {
    private final int bonusNumber;

    public UserBonusNumberInput() {
        this.bonusNumber = validateAndParseBonusNumber();
    }

    private int validateAndParseBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String userInput = Console.readLine();
                int parsedBonusNumber = parseBonusNumber(userInput);
                return rangeValidation(parsedBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 오류 메시지 출력 후 재입력
            }
        }
    }

    private int parseBonusNumber(String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수여야 합니다.");
        }
    }

    private int rangeValidation(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이의 정수여야 합니다.");
        }
        return bonusNumber;
    }
}
