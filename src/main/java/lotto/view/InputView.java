package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoWinningNumbers;
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

    public static LottoWinningNumbers inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine().trim();

        Set<Integer> winningNumbers = winningNumbersValidator.validateWinningNumbers(winningNumbersInput);
        System.out.println();

        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.createLottoWinningNumbers(winningNumbers);
        return lottoWinningNumbers;
    }

    public static int inputBonusWinningNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
        int bonusNumber = bonusWinningNumberValidator.validateBonusWinningNumber(inputBonusNumber);
        System.out.println();
        return bonusNumber;
    }

}
