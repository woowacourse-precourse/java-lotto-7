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

    public static int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String amount = read();
        int parseAmount = parseAndValidateAmount(amount);
        return parseAmount;
    }

    public static Lotto winningLotto() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBERS);
        String numbers = read();

        List<String> splitNumbers = splitByCommaAndValidateLength(numbers);
        List<Integer> parsedNumbers = convertToIntegerAndValidate(splitNumbers);

        return new Lotto(parsedNumbers);
    }

    private static List<String> splitByCommaAndValidateLength(String numbers) {
        String cleanedNumbers = trimSpaces(numbers);
        List<String> splitNumbers = splitByComma(cleanedNumbers);
        Validator.numbersLength(splitNumbers);

        return splitNumbers;
    }

    private static List<Integer> convertToIntegerAndValidate(List<String> numbers) {
        List<Integer> parsedNumbers = convertToInteger(numbers);
        validateInRange(parsedNumbers);
        Validator.numberDuplicate(parsedNumbers);

        return parsedNumbers;
    }

    private static void validateInRange(List<Integer> numbers) {
        numbers.forEach(Validator::numberInRange);
    }

    private static List<Integer> convertToInteger(List<String> numbers) {
        for (String number : numbers) {
            Validator.isNumber(number);
        }
        return numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<String> splitByComma(String cleanedNumbers) {
        return Stream.of(cleanedNumbers.split(","))
                .collect(Collectors.toList());
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
