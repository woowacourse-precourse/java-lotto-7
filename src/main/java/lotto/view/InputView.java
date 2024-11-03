package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    public static void winningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        String numbers = read();

        String cleanedNumbers = trimSpaces(numbers);
        List<String> splitNumbers = splitByComma(cleanedNumbers);

        Validator.numbersLength(splitNumbers);
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
