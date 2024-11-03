package lotto.view;

import lotto.dto.*;

public class OutputView {
    public void printPurchaseOverview(LottosDto lottosDto) {
        System.out.println(OutputMaker.makePurchaseOverview(lottosDto));
    }

    public void printWinningResult(WinningResultDto resultDto) {
        System.out.println(OutputMaker.makeFinalResult(resultDto));
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
