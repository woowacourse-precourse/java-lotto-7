package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String enteredPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInput();
    }

    public String enteredLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return getInput();
    }

    public String enteredLottoBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return getInput();
    }

    private String getInput() {
        return Console.readLine();
    }
}
