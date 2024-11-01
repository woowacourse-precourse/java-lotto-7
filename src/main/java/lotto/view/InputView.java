package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoNumberTypeValidator;
import lotto.exception.MoneyTypeValidator;

import java.util.List;

public class InputView {

    private final MoneyTypeValidator moneyTypeValidator;
    private final LottoNumberTypeValidator lottoNumberTypeValidator;

    public InputView() {
        moneyTypeValidator = new MoneyTypeValidator();
        lottoNumberTypeValidator = new LottoNumberTypeValidator();
    }

    public int getPurchasedMoney() {
        while (true) {
            try {
                System.out.println(OutputView.INPUT_MONEY_MESSAGE);
                return this.moneyTypeValidator.validateMoneyType(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {
        while (true) {
            try {
                System.out.println(OutputView.INPUT_WINNING_NUMBER_MESSAGE);
                return this.lottoNumberTypeValidator.validateWinningNumbersType(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        while (true){
            try {
                System.out.println(OutputView.INPUT_BONUS_NUMBER_MESSAGE);
                return this.lottoNumberTypeValidator.validateBonusNumberType(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
