package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                InputValidator.checkInput(input);
                int purchasePrice = InputValidator.checkNumber(input);
                InputValidator.checkUnit(purchasePrice);
                return purchasePrice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                InputValidator.checkInput(input);
                List<String> winningNumbersStr = Arrays.asList(input.split(","));
                List<Integer> winningNumbers = InputValidator.checkWinningNumbersStr(winningNumbersStr);
                InputValidator.checkWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        while (true) {
            try {
                String input = Console.readLine();
                InputValidator.checkInput(input);
                int bonusNumber = InputValidator.checkNumber(input);
                InputValidator.checkRangeBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
