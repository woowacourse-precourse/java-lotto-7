package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public static PurchaseAmount getPurchaseAmount() {
        while (true) {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            String input = Console.readLine();

            try {
                validateNotEmptyInput(input);
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNotEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static WinningLotto getWinningLotto() {
        WinningNumbers winningNumbers = getValidWinningNumbers();
        BonusNumber bonusNumber = getValidBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private static WinningNumbers getValidWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);

        while (true) {
            String input = Console.readLine();
            try {
                validateNotEmptyInput(input);
                List<Integer> numbers = parseInput(input);
                return new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + WINNING_NUMBERS_PROMPT);
            }
        }
    }

    private static BonusNumber getValidBonusNumber(WinningNumbers winningNumbers) {
        System.out.println(BONUS_NUMBER_PROMPT);

        while (true) {
            String input = Console.readLine().trim();

            try {
                validateNotEmptyInput(input);
                List<Integer> bonusNumber = parseInput(input);
                return new BonusNumber(bonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + BONUS_NUMBER_PROMPT);
            }
        }
    }

    private static List<Integer> parseInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_NOT_INTEGER.getMessage());
        }
    }

}
