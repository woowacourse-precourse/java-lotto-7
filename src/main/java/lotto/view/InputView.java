package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputMoneyValidator;
import lotto.validator.WinningNumbersValidator;

import java.util.Set;
import java.util.TreeSet;

public class InputView {

    private static final int LOTTO_PRICE = 1000;
    private static final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
    private static final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();


    public static long inputPurchaseMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseMoney = Console.readLine();
        inputMoneyValidator.validatePurchaseMoney(inputPurchaseMoney);
        System.out.println();

        return Long.parseLong(inputPurchaseMoney);
    }

    public static Set<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine().trim();

        Set<Integer> winningNumbers = winningNumbersValidator.validateWinningNumbers(winningNumbersInput);
        System.out.println();

        return winningNumbers;
    }

    public static int inputBonusWinningNumber(Set<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        if (!inputBonusNumber.matches("^\\d+$")) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자 하나만 입력해 주세요.");
        }
        int bonusNumber = Integer.parseInt(inputBonusNumber);
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 이상의 양수로 입력해 주세요.");
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        winningNumbers.add(bonusNumber);
        if (winningNumbers.size() != 7) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 기존의 당첨 번호들과 중복일 수 없습니다.");
        }
        System.out.println();
        return bonusNumber;
    }

}
