package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Request {

    public String inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String inputWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
