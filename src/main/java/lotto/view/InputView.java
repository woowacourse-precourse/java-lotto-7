package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessages;

public class InputView {

    private static final String PURCHASE_PRICE_MSG = "\n구입금액을 입력해 주세요.";

    public static Integer inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_MSG);
        String input = Console.readLine();
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_PURCHASE_PRICE_FORMAT.getMessage());
        }
        return Integer.parseInt(input);
    }
}
