package lotto.validator;

import java.util.Set;

public class InputBonusWinningNumberValidator {

    public static void validateBonusWinningNumber(String inputBonusNumber) {

        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }

        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validateDuplicateBonusWinningNumber(String inputBonusNumber, Set<Integer> winningNumbers) {

        if (winningNumbers.contains(Integer.parseInt(inputBonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
    }
}
