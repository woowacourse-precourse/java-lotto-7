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
                validateNotEmpty(input);
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(lotto.ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static WinningLotto getWinningLotto() {
        WinningLottoNumbers winningNumbers = getValidWinningNumbers();
        lotto.BonusNumber bonusNumber = getValidBonusNumber(winningNumbers);

        List<String> winningNumbersAsString = winningNumbers.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        return new WinningLotto(winningNumbersAsString, List.of(String.valueOf(bonusNumber.getNumber())));
    }


    private static WinningLottoNumbers getValidWinningNumbers() {
        System.out.println(WINNING_NUMBERS_PROMPT);

        while (true) {
            String input = Console.readLine();
            try {
                validateNotEmpty(input);
                List<String> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());
                return new WinningLottoNumbers(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + WINNING_NUMBERS_PROMPT);
            }
        }
    }

    private static lotto.BonusNumber getValidBonusNumber(WinningLottoNumbers winningNumbers) {
        System.out.println(BONUS_NUMBER_PROMPT);

        while (true) {
            String input = Console.readLine().trim();

            try {
                validateNotEmpty(input);
                List<String> bonusNumber = List.of(input.split(","));
                return new lotto.BonusNumber(bonusNumber, winningNumbers.getNumbers().stream()
                        .map(String::valueOf)
                        .collect(Collectors.toList()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + BONUS_NUMBER_PROMPT);
            }
        }
    }
}
