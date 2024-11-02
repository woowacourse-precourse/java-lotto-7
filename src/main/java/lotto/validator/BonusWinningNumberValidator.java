package lotto.validator;

import java.util.Set;

public class BonusWinningNumberValidator {
    public int validateBonusWinningNumber(Set<Integer> winningNumbers, String inputBonusNumber) {
        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상의 양수로 입력해 주세요.");
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        winningNumbers.add(bonusNumber);
        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }

        return bonusNumber;
    }
}
