package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine().strip();
    }

    public String enterWinningNumbers() {
        println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine().strip();
    }

    public String enterBonusNumbers() {
        println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLine().strip();
    }

    private void println() {
        System.out.println();
    }
}
