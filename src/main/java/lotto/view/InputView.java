package lotto.view;

import lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("\\d+");
    private static final Pattern WINNING_NUMBERS_REGEX = Pattern.compile("^\\d+(,\\d+)*$");
    private static final String NUMBER_DELIMITER = ",";

    public static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("구입금액을 입력해 주세요.");
            String amount = readLine();
            addBlankLine();

            try {
                validatePurchaseAmount(amount);
                purchaseAmount = Integer.parseInt(amount);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return purchaseAmount;
    }

    static void validatePurchaseAmount(String amount) {
        if (amount == null || amount.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }
        if (!NUMERIC_REGEX.matcher(amount).matches()) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자로 입력해야 합니다.");
        }
        int convertAmount = Integer.parseInt(amount);
        if (convertAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static Lotto inputWinningNumbers() {
        Lotto winningNumbers = null;
        List<Integer> inputWinningNumbers = null;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = readLine();
            addBlankLine();

            try {
                validateWinningNumbers(input);
                inputWinningNumbers = convertWinningNumbers(input);
                winningNumbers = new Lotto(inputWinningNumbers);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    static void validateWinningNumbers(String input) {
        if (!WINNING_NUMBERS_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자와 쉼표로만 입력해야 합니다.");
        }
    }

    private static List<Integer> convertWinningNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber(Lotto winningNumbers) {
        int bonusNumber = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = readLine();
            addBlankLine();

            try {
                validateBonusNumber(input, winningNumbers);
                bonusNumber = Integer.parseInt(input);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return bonusNumber;
    }

    static void validateBonusNumber(String bonusNumber, Lotto winningNumbers) {
        if (bonusNumber == null || bonusNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
        if (!NUMERIC_REGEX.matcher(bonusNumber).matches()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
        }
        int convertBonusNumber = Integer.parseInt(bonusNumber);
        if (convertBonusNumber < 1 || convertBonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.getLotto().contains(convertBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    private static void addBlankLine() {
        System.out.println();
    }
}
