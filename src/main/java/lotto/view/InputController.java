package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.service.InputService;

public class InputController {
    public static int purchase;

    public static void purchaseInput() {
        purchase = Integer.parseInt(readLine());
        InputService.validatePurchase();
        InputService.getLottoAmount();
    }


}
