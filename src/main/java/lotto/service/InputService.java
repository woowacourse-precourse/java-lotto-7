package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.InputConstants;

public class InputService {
    public void getPurchaseAmount() {
        System.out.println(InputConstants.PURCHASE_AMOUNT_INSTRUCTION);
        Console.readLine();
    }
}
