package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int buyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효한 숫자를 입력해 주세요.");
            return buyPrice();
        }
    }
}
