package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    final InputValidator inputValidator = new InputValidator();

    public int getPayment() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return inputValidator.getValidPurchasedLottoAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
