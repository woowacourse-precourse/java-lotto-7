package lotto;

public class InputValidator {
    static void validatePurchaseAmount(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }

        int purchaseAmount = Integer.parseInt(input);

        if (purchaseAmount % 1000 !=0) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 로또 가격으로 나누어지지 않습니다.");
        }
    }

    static int validateBonusNumber(String input, Lotto winningLotto) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 양수가 아닙니다.");
        }

        int bonusNumber = Integer.parseInt(input.trim());

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        if (winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복되지 않는 숫자여야 합니다.");
        }

        return bonusNumber;
    }
}
