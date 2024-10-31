package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Console.readLine();
    }

    public void getLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Console.readLine();
    }

    public void getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Console.readLine();
    }
}
