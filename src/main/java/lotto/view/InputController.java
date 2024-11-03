package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.service.InputService;

public class InputController {
    public static int purchase;

    public static void purchaseInput() {
        purchase = Integer.parseInt(readLine());
        if (purchase < 1000) {
            throw new IllegalArgumentException("[ERROR] 1,000원 이상부터 구매 가능합니다.");
        }
        InputService.getLottoAmount();
    }
}
