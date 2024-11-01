package lotto.io;

import static lotto.vo.OutputMessage.BONUS_NUMBER_INPUT;
import static lotto.vo.OutputMessage.PRICE_INPUT;
import static lotto.vo.OutputMessage.TOTAL_LOTTO_QUANTITY;
import static lotto.vo.OutputMessage.WINNING_NUMBER_INPUT;

public class Output {

    public static void priceInputMessage() {
        System.out.println(PRICE_INPUT.getMessage());
    }

    public static void totalLottoQuantityMessage(int quantity) {
        System.out.println(TOTAL_LOTTO_QUANTITY.getMessage(quantity));
    }

    public static void winningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT.getMessage());
    }

    public static void bonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT.getMessage());
    }

}
