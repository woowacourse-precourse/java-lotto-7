package lotto.validator;

import lotto.model.Lotto;

public class BonusNumberValidator {

    public void validBonusNumber(String num, Lotto winningNumbers) {
        try {
            if (num == null || num.trim().isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 비어있을 수 없습니다.");
            }

            int number = Integer.parseInt(num);

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1에서 45 사이의 값만 입력 가능합니다.");
            }

            // 로또 번호와 중복 체크
            if (winningNumbers.getNumbers().contains(number)) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 로또 번호와 중복될 수 없습니다.");
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 1에서 45 사이의 정수여야 합니다.");
        }
    }

}