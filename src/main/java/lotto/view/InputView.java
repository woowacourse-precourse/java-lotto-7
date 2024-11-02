package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BuyingAmountException;
import lotto.exception.IllegalLottoNumberException;
import lotto.validator.BuyingAmountValidator;
import lotto.validator.WinningNumberValidator;

import java.util.List;

public class InputView {
    private final BuyingAmountValidator buyingAmountValidator = new BuyingAmountValidator();
    private final WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
    private static final String GET_BUYING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String GET_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public int getBuyingAmount() {
        try {
            System.out.println(GET_BUYING_AMOUNT);
            String input = Console.readLine();
            return buyingAmountValidator.validateBuyingAmount(input);
        } catch (BuyingAmountException e) {
            System.out.println(e.getMessage());
            return getBuyingAmount();
        }
    }

    public List<Integer> getWinningNumbers() {
        try {
            System.out.println(GET_WINNING_NUMBERS);
            String input = Console.readLine();
            return winningNumberValidator.validateWinningNumbers(input);
        } catch (IllegalLottoNumberException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    public int getBonusNumber(List<Integer> winningNumbers) {
        try {
            System.out.println(GET_BONUS_NUMBER);
            String input = Console.readLine();
            return winningNumberValidator.validateBonusNumber(winningNumbers, input);
        } catch (IllegalLottoNumberException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }
}
