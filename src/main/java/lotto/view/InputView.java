package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_PROMPT = "당첨 번호를 (,)로 구분하여 입력해 주세요. (입력 예시: 1,2,3,4,5,6)";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final int MONEY_UNIT = 1000;
    private static final String ERROR_NON_NUMERIC = "[ERROR] 구입 금액은 숫자여야 합니다.";
    private static final String ERROR_INVALID_UNIT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    private static final String ERROR_WINNING_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    private static final String COMMA = ",";
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 45;
    private static final String ERROR_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호의 범위는 1 이상 45 이하여야 합니다.";
    public static int requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_PROMPT);
                String purchaseAmount = Console.readLine();
                validatePurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount) / MONEY_UNIT;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmount) {
        int amount;
        try {
            amount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC);
        }

        if (amount < MONEY_UNIT || amount % MONEY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_UNIT);
        }
    }

    public static Lotto requestWinningNumbers() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_PROMPT);
                String winningNumbers = Console.readLine();
                validateWinningNumbers(winningNumbers);
                return parseWinningNumbers(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Lotto parseWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(COMMA);

        List<Integer> parsedNumbers = new ArrayList<>();
        for (int i = 0; i < WINNING_NUMBER_COUNT; i++) {
            parsedNumbers.add(Integer.parseInt(numbers[i].trim()));
        }

        return new Lotto(parsedNumbers);
    }

    private static void validateWinningNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(COMMA);
        if (numbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ERROR_WINNING_COUNT);
        }
    }

    public static int requestBonusNumber() {
        while (true) {
            try {
                System.out.println(BONUS_NUMBER_PROMPT);
                String bonusNumber = Console.readLine();
                validateBonusNumber(bonusNumber);
                return Integer.parseInt(bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateBonusNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        if (number < START_INCLUSIVE || number > END_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_BONUS_NUMBER_RANGE);
        }
    }
}
