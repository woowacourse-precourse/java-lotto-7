package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoArgumentException;

public class UserView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int printAndGetAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return getAmount();
    }

    private static int getAmount() {
        while (true) {
            try {
                return checkAmount(Console.readLine());
            } catch (LottoArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int checkAmount(String inputAmount) {
        if (inputAmount == null || inputAmount.equals("\n") || inputAmount.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_AMOUNT_ERROR);
        }

        try {
            int amount = Integer.parseInt(inputAmount);

            if (amount < 1000) {
                throw new LottoArgumentException(LottoErrorMessage.LESS_MIN_AMOUNT_ERROR);
            }

            if (amount % 1000 != 0) {
                throw new LottoArgumentException(LottoErrorMessage.DIV_1_000_AMOUNT_ERROR);
            }

            return amount;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_AMOUNT_ERROR);
        }
    }
}
