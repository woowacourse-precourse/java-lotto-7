package lotto;

import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validatePurchaseAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String sanitizedInput = input.replace(" ", "");
        if (!sanitizedInput.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자 형식으로 입력해 주세요.");
        }

        List<Integer> winningNumbers = Arrays.stream(sanitizedInput.split(","))
                .map(Integer::parseInt).toList();

        if (winningNumbers.size() != 6 || !isValidLottoNumbers(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
        }
        return winningNumbers;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (input.contains(",") || !input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 하나의 숫자로 입력해 주세요.");
        }

        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
    }

    public static boolean isValidLottoNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= 1 && num <= 45) &&
                numbers.stream().distinct().count() == numbers.size();
    }
}