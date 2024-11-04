package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.validator.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static String getPrice() {
        printPricePrompt();
        return readValidPrice();
    }

    private static String readValidPrice() {
        String input = Console.readLine();
        if (isValidPrice(input)) {
            return input;
        }
        return readValidPrice();
    }

    public static Lotto getWinningNumbers() {
        printWinningNumbersPrompt();
        return readValidWinningLotto();
    }

    private static Lotto readValidWinningLotto() {
        String input = Console.readLine();
        try {
            List<Integer> numberList = parseNumbers(input);
            LottoValidator.validateWinningNumbers(numberList);
            return new Lotto(numberList);
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
            return readValidWinningLotto();
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        printBonusNumberPrompt();
        return readValidBonusNumber(winningNumbers);
    }

    private static int readValidBonusNumber(List<Integer> winningNumbers) {
        String input = Console.readLine();
        try {
            int bonusNumber = Integer.parseInt(input);
            LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            printErrorMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
        return readValidBonusNumber(winningNumbers);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printPricePrompt() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    private static void printWinningNumbersPrompt() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private static void printBonusNumberPrompt() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    private static void printErrorMessage(String message) {
        System.out.println(message);
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
}
