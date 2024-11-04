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
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String amount = read();

        return parseAndValidateAmount(amount);
    }

    public static Lotto winningLotto() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        String numbers = read();

        List<String> splitNumbers = splitByComma(numbers);
        List<Integer> parsedNumbers = convertToInteger(splitNumbers);

        return new Lotto(parsedNumbers);
    }

    public static int bonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNumber = read();

        return parseNumber(bonusNumber);
    }

    private static int parseNumber(String bonusNumber) {
        String cleanedNumber = trimSpaces(bonusNumber);
        Validator.isNumber(cleanedNumber);

        return Integer.parseInt(cleanedNumber);
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
