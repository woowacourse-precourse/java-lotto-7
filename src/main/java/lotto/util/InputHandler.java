package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Purchase;
import java.util.function.Function;

import static lotto.constant.IOMessage.BONUS_NUMBER_INPUT_MESSAGE;
import static lotto.constant.IOMessage.LOTTO_NUMBER_INPUT_MESSAGE;
import static lotto.constant.IOMessage.ORDER_AMOUNT_INPUT_MESSAGE;

public class InputHandler {
    public static Bonus repeatInputBonusNumber(Lotto lotto) {
        while (true) {
            try {
                Bonus bonus = repeatInput(Parser::parseBonusNumber, BONUS_NUMBER_INPUT_MESSAGE);
                validateDuplicatedWithLotto(lotto, bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateDuplicatedWithLotto(Lotto lotto, Bonus bonus) {
        if(lotto.getNumbers().contains(bonus.getNumber())){
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    public static Lotto repeatInputLottoNumber() {
        return repeatInput(Parser::parseLotto, LOTTO_NUMBER_INPUT_MESSAGE);
    }

    public static Purchase repeatInputOrderCost() {
        return repeatInput(Parser::parsePurchase, ORDER_AMOUNT_INPUT_MESSAGE);
    }

    private static <T> T repeatInput(Function<String, T> parser, String message) {
        while(true) {
            try {
                String input = getInput(message);
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getInput(String message) {
        System.out.println("");
        System.out.println(message);
        return Console.readLine().trim();
    }
}
