package lotto.validator;

import java.util.List;
import java.util.Set;

public class BonusNumberValidator {
    private int bonusNumber = 0;

    public boolean isNotValidBonusNumber(String userInput, Set<Integer> winningNumbers) {
        if (isNotParsableToBonusNumber(userInput)) {
            return true;
        }
        if (isInvalidNumber(bonusNumber)) {
            return true;
        }
        if (isDuplicateWinnerNumbers(bonusNumber, winningNumbers)) {
            return true;
        }
        return false;
    }

    private boolean isNotParsableToBonusNumber(String userInput) {
        try {
            bonusNumber = Integer.parseInt(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 올바른 숫자형식을 입력해 주세요.");
            return true;
        }
        return false;
    }

    private boolean isInvalidNumber(int bonusNumber) {
        try {
            if (bonusNumber < 1 || 45 < bonusNumber) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            return true;
        }
        return false;
    }

    private boolean isDuplicateWinnerNumbers(int bonusNumber, Set<Integer> winningNumbers) {
        try {
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 보너스 번호는 당첨 번호에 없는 번호이어야 합니다.");
            return true;
        }
        return false;
    }

}
