package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public long getUserInputMoney() {
        System.out.println("구입금액을 선택해주세요.");
        try {
            return Long.parseLong(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
