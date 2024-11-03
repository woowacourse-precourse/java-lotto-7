package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int price() {
        System.out.print("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
