package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;
import lotto.exception.LottoException;
import lotto.utils.LottoUtils;

public class Input {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구매 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해주세요.";

    public int printPurchaseAmountInputMessage() {
        while (true) {
            try {
                System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);

                String input = Console.readLine();
                LottoException.throwIllegalArgumentException(ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(input));

                return LottoUtils.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String printWinningNumberInputMessage() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_INPUT_MESSAGE);

                String input = Console.readLine();
                LottoException.throwIllegalArgumentException(ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(input));

                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int printBonusNumberInputMessage() {
        while (true) {
            try {
                System.out.println();
                System.out.println(BONUS_NUMBER_INPUT_MESSAGE);

                String input = Console.readLine();
                LottoException.throwIllegalArgumentException(ExceptionMessage.NOT_EMPTY_STRINGS, LottoUtils.isBlank(input));

                return LottoUtils.parseInt(input);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
