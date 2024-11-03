package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.OutputMessage;
import lotto.validator.LottoNumberTypeValidator;
import lotto.validator.MoneyTypeValidator;

import java.util.List;

public class InputView {

    private final MoneyTypeValidator moneyTypeValidator;
    private final LottoNumberTypeValidator lottoNumberTypeValidator;

    public InputView() {
        moneyTypeValidator = new MoneyTypeValidator();
        lottoNumberTypeValidator = new LottoNumberTypeValidator();
    }

    public int getPurchasedMoney() {
        try {
            System.out.println(OutputMessage.INPUT_MONEY_MESSAGE.getMessage());
            return this.moneyTypeValidator.validateMoneyType(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchasedMoney();
        }
    }

    public List<Integer> getWinningNumbers() {
        try {
            System.out.println(OutputMessage.INPUT_WINNING_NUMBER_MESSAGE.getMessage());
            return this.lottoNumberTypeValidator.validateWinningNumbersType(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber() {
        try {
            System.out.println(OutputMessage.INPUT_BONUS_NUMBER_MESSAGE.getMessage());
            return this.lottoNumberTypeValidator.validateBonusNumberType(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }
}
