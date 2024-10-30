package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Integer inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("올바른 숫자를 입력해 주세요.");
            return inputPurchaseMoney();
        }
    }
}
