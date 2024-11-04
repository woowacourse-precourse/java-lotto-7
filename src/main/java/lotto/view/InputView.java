package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoConstants;
import lotto.domain.BonusLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.Parser;
import lotto.util.Validator;

import java.util.List;

public class InputView {
    public static Money inputMoney() {
        while (true) {
            try {
                System.out.println(LottoConstants.INPUT_PURCHASE_AMOUNT);
                String input = readLine();

                Validator.validateNumeric(input);
                int amount = Parser.parseToInt(input);
                Validator.validateAmount(amount);

                return new Money(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumber() {
        while (true) {
            try {
                System.out.println(LottoConstants.INPUT_WINNING_NUMBER);
                String input = readLine();
                List<Integer> winningNumbers = Parser.parseStringToIntegerList(input);

                return new Lotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static BonusLotto inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println(LottoConstants.INPUT_BONUS_NUMBER);
                String input = readLine();
                Validator.validateNumeric(input);
                int bonusNumber = Parser.parseToInt(input);

                return new BonusLotto(bonusNumber, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String readLine() {
        return Console.readLine();
    }
}