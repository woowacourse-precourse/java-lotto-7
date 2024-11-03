package lotto;

import java.util.List;

public class LottoValidator {
    private LottoValidator() {}

    // 구입 금액 검증: 1,000원 단위가 아니면 예외 발생
    public static int validatePurchaseAmountInput(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount <= 0 || amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해 주세요.");
        }
    }

    // 로또 번호 유효성 검증: 6개 번호, 1~45 범위, 중복 없음
    public static void validateLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
        }
    }

    // 당첨 번호와 보너스 번호 중복 및 범위 검증
    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
