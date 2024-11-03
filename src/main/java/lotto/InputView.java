package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static User createUser() {
        System.out.println("구입 금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());
        return new User(money);
    }
}
