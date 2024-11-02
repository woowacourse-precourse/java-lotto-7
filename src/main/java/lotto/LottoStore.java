package lotto;

import static lotto.constant.DefaultPrompt.ENTER_PURCHASE_AMOUNT_TEXT;
import static lotto.constant.DefaultPrompt.RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE;
import static lotto.constant.DefaultPrompt.display;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.DefaultPrompt;
import lotto.domain.AutomaticLottoMachine;

public class LottoStore {
    private static final int LOTTO_PRICE_UNIT = 1000;

    public static final String ERROR_THE_AMOUNT_IN_WON_UNITS_TEMPLATE = "[ERROR] %d 원 단위의 금액을 입력해야 합니다.";
    public static final String ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT = "[ERROR] 구입금액에는 숫자만을 입력해야 합니다.";
    public static final String ERROR_LIMITED_IN_SIZE = "[ERROR] 인당 최대 %d 개 까지만 구입 가능합니다.";

    public void open() {
        var automaticLottoMachine = issue();
        RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE.display(
                automaticLottoMachine.getQuantity(),
                automaticLottoMachine);
    }

    private AutomaticLottoMachine issue() {
        while (true) {
            try {
                int amount = enterPurchaseAmount();
                DefaultPrompt.display("");

                return new AutomaticLottoMachine(amount);
            } catch (IllegalArgumentException e) {
                display(e.getMessage());
            }
        }
    }

    private int enterPurchaseAmount() {
        ENTER_PURCHASE_AMOUNT_TEXT.display();
        String rawAmount = Console.readLine();
        validateEnter(rawAmount);

        return parse(rawAmount);
    }


    private static void validateEnter(String rawPurchaseAmount) {
        if (rawPurchaseAmount == null || rawPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT);
        }
    }

    private int parse(String rawPurchaseAmount) {
        try {
            return Integer.parseInt(rawPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBERS_FOR_THE_PURCHASE_AMOUNT);
        }
    }

}
