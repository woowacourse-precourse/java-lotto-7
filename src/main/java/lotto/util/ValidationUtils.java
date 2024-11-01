package lotto.util;

import java.util.Set;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static void validateBuyAmount(String buyInput) {
        // 빈 문자열 입력 시 예외 발생
        if (buyInput == null || buyInput.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }

        try {
            int buy = Integer.parseInt(buyInput);

            // 양수가 아니거나 1,000원 단위가 아닌 경우 예외 발생
            if (buy <= 0 || buy % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 하며, int 범위를 초과할 수 없습니다.", e);
        }
    }

    public static void validateWinningNumbers(Set<String> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복 없이 6개의 숫자여야 합니다.");
        }

        for (String num : numbers) {
            if (!Pattern.matches("\\d+", num) || Integer.parseInt(num) < 1 || Integer.parseInt(num) > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
