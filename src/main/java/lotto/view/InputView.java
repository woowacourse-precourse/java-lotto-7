package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.LottoConstants;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        String input = Console.readLine();
        int amount = parseInteger(input, "[ERROR] 구입 금액은 숫자여야 합니다.");
        validatePurchaseAmount(amount);
        return amount;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String input = Console.readLine();
        List<Integer> numbers = parseIntegerList(input, "[ERROR] 당첨 번호는 숫자여야 합니다.");
        validateWinningNumbers(numbers);
        return numbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        String input = Console.readLine();
        int bonusNumber = parseInteger(input, "[ERROR] 보너스 번호는 숫자여야 합니다.");
        validateBonumNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseInteger(String input, String errorMessage) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static List<Integer> parseIntegerList(String input, String errorMessage) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE != 0 || amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (hasInvalidRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateBonumNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }
    }

    private static boolean hasInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(num -> num < LottoConstants.LOTTO_MIN_NUMBER || num > LottoConstants.LOTTO_MAX_NUMBER);
    }

    private static boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
