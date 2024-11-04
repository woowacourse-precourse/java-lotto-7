package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;

public class InputService {
    private final InputException inputException = new InputException();

    public int inputPurchaseAmount(int ticketPrice) {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        inputException.validateInputEmpty(purchaseAmount);

        int purchaseAmountValue = convertToNumericPurchaseAmount(purchaseAmount);

        inputException.validateDivisibleByTicketPrice(purchaseAmountValue, ticketPrice);

        return purchaseAmountValue;
    }

    public int convertToNumericPurchaseAmount(String input) {
        inputException.validateNumericInput(input);
        return Integer.parseInt(input);
    }
}
