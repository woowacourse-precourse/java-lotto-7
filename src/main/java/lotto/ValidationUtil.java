package lotto;

import java.util.HashSet;
import java.util.Set;

public class ValidationUtil {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public static void validateAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수로 입력해야 합니다.");
        }
    }

    public static int parseAndValidateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야 합니다.");
        }
    }

    public static void validateLottoNumbers(Set<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입니다.");
        }

        for (int number : numbers) {
            if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void validateBonusNumber(int bonusNumber, Set<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."));
        }
    }

    public Set<Integer> parseAndValidateWinningNumbers(String input) {
        try {
            String[] tokens = input.split(",");

            if(tokens.length != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 쉽표로 구분된 6개의 숫자여야 합니다.");
            }

            Set<Integer> numbers = new HashSet<>();
            for (String token : tokens) {
                int number = parseAndValidateNumber(token.trim());
                numbers.add(number);
            }

            validateLottoNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45사이의 숫자 6개여야 합니다.");
        }
    }
}
