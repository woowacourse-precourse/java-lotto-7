package lotto.validator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.constants.LottoConstants.*;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    public static List<Integer> validateWinningNumbersInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 비어 있을 수 없습니다. 올바른 번호를 입력해 주세요.");
        }
        if (input.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 입력 형식이 잘못되었습니다.");
        }

        try {
            return Stream.of(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 번호가 올바르지 않습니다. 숫자만 입력해 주세요.");
        }
    }

    public static void validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나의 숫자여야 합니다.");
        }

        try {
            int bonusNumber = Integer.parseInt(input);
            validateBonusNumber(bonusNumber, winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이어야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
