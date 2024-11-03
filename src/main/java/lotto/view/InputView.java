package lotto.view;

import lotto.util.CommonIo;

public class InputView {
    private final CommonIo io;

    public InputView(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase() {
        io.printMessage("구입금액을 입력해 주세요.");
    }

    public void printRequestWinningNumbers(){
        io.printMessage("당첨 번호를 입력해 주세요.");
    }

    public void printRequestBonusNumber(){
        io.printMessage("보너스 번호를 입력해 주세요.");
    }

}
