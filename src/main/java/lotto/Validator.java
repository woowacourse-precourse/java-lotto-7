package lotto;

import static lotto.LottoConstant.MAX_VALUE;
import static lotto.LottoConstant.MIN_VALUE;
import static lotto.LottoConstant.PRICE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validatePurchaseAmount(long input) {
        if (input % 1000 != 0 || input / 1000 < 1) {
            throw new IllegalArgumentException("구매 금액은 " + PRICE + "원 단위로 입력해야 합니다.");
        }
    }

    public static void validateWinningNumbers(List<Integer> drawNumbers) {
        if (drawNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개 입니다.");
        }
        validateUniqueNumbers(drawNumbers);
        drawNumbers.forEach(Validator::validateNumberRange);
    }

    public static void validateBonusNumber(int drawNumber, List<Integer> winningNumbers) {
        validateNumberRange(drawNumber);
        if (winningNumbers.contains(drawNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복되지 않아야 합니다.");
        }
    }

    public static void validateNumberRange(int drawNumber) {
        if (drawNumber >= MIN_VALUE && drawNumber <= MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException("번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    public static void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 번호 없어야 합니다.");
        }
    }
}
