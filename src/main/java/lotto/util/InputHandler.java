package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.Purchase;

import java.util.function.Function;

import static lotto.constant.IOMessage.BLANK_LINE;
import static lotto.constant.IOMessage.INPUT_BONUS_NUMBER;
import static lotto.constant.IOMessage.INPUT_LOTTO_NUMBER;
import static lotto.constant.IOMessage.INPUT_ORDER_AMOUNT;

public class InputHandler {
    public static Bonus repeatInputBonusNumber(Lotto lotto) {
        while (true) {
            try {
                Bonus bonus = repeatInput(Parser::parseBonusNumber, INPUT_BONUS_NUMBER.getMessage());
                validateDuplicatedWithLotto(lotto, bonus);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateDuplicatedWithLotto(Lotto lotto, Bonus bonus) {
        if (lotto.getNumbers().contains(bonus.getNumber())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }

    public static Lotto repeatInputLottoNumber() {
        return repeatInput(Parser::parseLotto, INPUT_LOTTO_NUMBER.getMessage());
    }

    public static Purchase repeatInputOrderCost() {
        return repeatInput(Parser::parsePurchase, INPUT_ORDER_AMOUNT.getMessage());
    }

    private static <T> T repeatInput(Function<String, T> parser, String message) {
        while (true) {
            try {
                String input = getInput(message);
                return parser.apply(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getInput(String message) {
        System.out.println(BLANK_LINE.getMessage());
        System.out.println(message);
        return Console.readLine().trim();
    }
}
