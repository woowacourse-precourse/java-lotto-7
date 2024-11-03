package lotto.ui;

public class OutputController {
    private final OutputUi outputUi;

    public OutputController(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }

    public void printPurchaseInfo() {
        outputUi.printWithLineBreak("구입금액을 입력해 주세요.");
    }
}
