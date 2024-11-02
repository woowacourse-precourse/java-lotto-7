package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.converter.StringToIntegerSetConverter;
import lotto.validator.BonusWinningNumberValidator;
import lotto.validator.InputMoneyValidator;
import lotto.validator.WinningNumbersValidator;

import java.util.Set;

public class InputView {

    private static final InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
    private static final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();
    private static final BonusWinningNumberValidator bonusWinningNumberValidator = new BonusWinningNumberValidator();


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
        winningNumbersValidator.validateWinningNumbers(winningNumbersInput);

        Set<Integer> winningNumbers = StringToIntegerSetConverter.convertToTreeSet(winningNumbersInput);
        winningNumbersValidator.validateDuplicateWinningNumbers(winningNumbers);

        System.out.println();
        return winningNumbers;
    }

    public static int inputBonusWinningNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        int bonusNumber = bonusWinningNumberValidator.validateBonusWinningNumber(inputBonusNumber);
        System.out.println();
        return bonusNumber;
    }

}
