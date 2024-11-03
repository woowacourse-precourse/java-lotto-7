package lotto.exceptioin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {

    // 구매 금액 유효성 검증
    public void validateMoney(int money) {
        if (money <= 0 || money % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    // 로또 번호 개수, 범위 및 중복 검증
    public void validateLottoNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개의 숫자로 입력되어야 합니다.");
        }
        // 중복 검사
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않는 숫자여야 합니다.");
        }
        // 각 번호 범위 검사
        for (Integer number : numbers) {
            validateLottoNumberRange(number);
        }
    }

    // 각 로또 번호 범위 검증
    private void validateLottoNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    // 보너스 번호 범위 검증
    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
