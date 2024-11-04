package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;

import static lotto.converter.StringToIntegerSetConverter.convertToTreeSet;
import static lotto.validator.BonusWinningNumberValidator.validateBonusWinningNumber;
import static lotto.validator.InputMoneyValidator.validatePurchaseMoney;
import static lotto.validator.WinningNumbersValidator.validateDuplicateWinningNumbers;
import static lotto.validator.WinningNumbersValidator.validateWinningNumbers;

public class InputView {

    public static long inputPurchaseMoney() {

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String inputPurchaseMoney = Console.readLine().trim();
                validatePurchaseMoney(inputPurchaseMoney);
                System.out.println();
                return Long.parseLong(inputPurchaseMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Set<Integer> inputWinningNumbers() {

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningNumbersInput = Console.readLine().trim();
                validateWinningNumbers(winningNumbersInput);
                Set<Integer> winningNumbers = convertToTreeSet(winningNumbersInput);
                validateDuplicateWinningNumbers(winningNumbers);
                System.out.println();
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusWinningNumber() {

        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine().trim();
                validateBonusWinningNumber(inputBonusNumber);
                System.out.println();
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
