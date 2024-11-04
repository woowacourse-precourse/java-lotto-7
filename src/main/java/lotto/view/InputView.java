package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static String getPrice() {
        while (true) {
            printPricePrompt();
            String input = Console.readLine();
            if (isValidPrice(input)) {
                return input;
            }
        }
    }

    private static void printPricePrompt() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private static boolean isValidPrice(String input) {
        try {
            LottoValidator.validatePrice(input);
            return true;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return false;
        }
    }

    public static Lotto getWinningNumbers() {
        while (true) {
            printWinningNumbersPrompt();
            String input = Console.readLine();
            Lotto lotto = createWinningLotto(input);
            if (lotto != null) {
                return lotto;
            }
        }
    }

    private static void printWinningNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static Lotto createWinningLotto(String input) {
        try {
            List<Integer> numberList = parseNumbers(input);
            LottoValidator.validateWinningNumbers(numberList);
            return new Lotto(numberList);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return null;
        }
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            printBonusNumberPrompt();
            String input = Console.readLine();
            Integer bonusNumber = parseBonusNumber(input, winningNumbers);
            if (bonusNumber != null) {
                return bonusNumber;
            }
        }
    }

    private static void printBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static Integer parseBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            printErrorMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
            return null;
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return null;
        }
    }

    private static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
