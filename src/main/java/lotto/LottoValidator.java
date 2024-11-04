package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int REQUIRED_LOTTO_NUMBERS = 6;


    public static void validateNumericInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 필요합니다.");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static void validateLottoNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public static void validatePurchaseInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해주세요.");
        }

        try {
            int amount = Integer.parseInt(input);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
            }
            if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식의 구입 금액을 입력해주세요.");
        }
    }


    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.size() != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 6개의 당첨 번호를 입력해주세요.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : winningNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자가 포함될 수 없습니다.");
            }
        }
    }


    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }


    public static void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개의 숫자여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int number : lottoNumbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다.");
            }
        }
    }


    public static void validateCommaSeparatedNumbers(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력이 필요합니다.");
        }

        String[] numbers = input.split(",");
        if (numbers.length != REQUIRED_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String num : numbers) {
            try {
                int number = Integer.parseInt(num.trim());
                if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                    throw new IllegalArgumentException("[ERROR] 숫자는 1부터 45 사이여야 합니다.");
                }
                if (!uniqueNumbers.add(number)) {
                    throw new IllegalArgumentException("[ERROR] 중복된 숫자가 포함되어 있습니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 포함해야 합니다.");
            }
        }
    }
}
