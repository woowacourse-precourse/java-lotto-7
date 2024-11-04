package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.utils.Validator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static int purchaseAmount() {
        while (true) {
            try {
                System.out.println(INPUT_PURCHASE_AMOUNT);
                String amount = read();
                return parseAndValidateAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public static Lotto winningLotto() {
        while (true) {
            try {
                System.out.println();
                System.out.println(INPUT_WINNING_NUMBERS);
                String numbers = read();

                List<String> splitNumbers = splitByComma(numbers);
                List<Integer> parsedNumbers = convertToInteger(splitNumbers);

                return new Lotto(parsedNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int bonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println();
                System.out.println(INPUT_BONUS_NUMBER);
                String bonusNumber = read();

                return parseAndValidateDuplication(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int parseAndValidateDuplication(List<Integer> winningNumbers, String bonusNumber) {
        String cleanedNumber = trimSpaces(bonusNumber);
        Validator.isNumber(cleanedNumber);
        int parsedBonusNumber = Integer.parseInt(cleanedNumber);

        Validator.numberIsUnique(winningNumbers, parsedBonusNumber);
        return parsedBonusNumber;
    }

    private static List<String> splitByComma(String numbers) {
        String cleanedNumbers = trimSpaces(numbers);

        return Stream.of(cleanedNumbers.split(","))
                .collect(Collectors.toList());
    }

    private static List<Integer> convertToInteger(List<String> numbers) {
        validateIsNumber(numbers);
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validateIsNumber(List<String> numbers) {
        for (String number : numbers) {
            Validator.isNumber(number);
        }
    }

    private static String trimSpaces(String numbers) {
        return numbers.replaceAll("\\s+", "");
    }

    private static int parseAndValidateAmount(String amount) {
        Validator.isNumber(amount);
        int parseAmount = Integer.parseInt(amount);
        Validator.amountIsMultipleOf1000(parseAmount);
        return parseAmount;
    }

    private static String read() {
        return Console.readLine();
    }
}
