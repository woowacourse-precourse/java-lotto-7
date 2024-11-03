package lotto.view;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^\\d+(,\\d+)*$");
    private static final String NUMBER_DELIMITER = ",";

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = readLine();
        addBlankLine();
        validatePurchaseAmount(amount);
        return Integer.parseInt(amount);
    }

    static void validatePurchaseAmount(String amount) {
        if (!NUMERIC_PATTERN.matcher(amount).matches()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }
        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        addBlankLine();
        validateWinningNumbers(input);
        List<Integer> winningNumbers = convertWinningNumbers(input);
        return new Lotto(winningNumbers);
    }

    static void validateWinningNumbers(String input) {
        if (!WINNING_NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
        }
    }

    private static List<Integer> convertWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
