package lotto.view;

import static lotto.vaildate.Validate.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_PRICE_INPUT = "구입금액을 입력해 주세요.";

    public int buyLottoPriceInput() {
        System.out.println(START_PRICE_INPUT);
        return readLottoPrice();
    }

    private int readLottoPrice() {
        try {
            return purchasePriceValidate(consoleReadLine());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readLottoPrice();
        }
    }

    private static String consoleReadLine() {
        String line = Console.readLine();
        System.out.println();
        return line;
    }

    private void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }


}
