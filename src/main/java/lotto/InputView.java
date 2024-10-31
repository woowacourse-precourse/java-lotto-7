package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final int AMOUNT_UNIT = 1000;
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE_AMOUNT = "[ERROR] 구입금액은 1000원 단위로 입력해 주세요.";


    public int inputPurchaseAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return checkAmount(readLine());
    }

    public int checkAmount(String input) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT);
        }
        if (amount < AMOUNT_UNIT || amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_AMOUNT);
        }
        return amount;
    }
}
