package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator {

    public static void validatePurchaseAmount(String input) {
        int amount = parsePositiveInteger(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parsePositiveInteger(input);
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        validateNumberRange(bonusNumber);
    }

    public static List<Integer> parseLottoNumbers(String input) {
        List<Integer> numbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(LottoValidator::parsePositiveInteger)
                .collect(Collectors.toList());
        validateNumbers(numbers);
        return numbers;
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        for (int number : numbers) {
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static int parsePositiveInteger(String input) {
        try {
            int number = Integer.parseInt(input.trim());
            if (number <= 0) {
                throw new IllegalArgumentException("[ERROR] 양수를 입력해야 합니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }
}