package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    public int getLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String getSelectedNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
