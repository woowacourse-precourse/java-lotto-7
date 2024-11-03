package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Profit;
import lotto.domain.WinningResult;

public class OutputView extends OutputWriter {
    public void requestLottoMoney() {
        displayMessage("구입금액을 입력해 주세요.");
    }

    public void displayPurchaseQuantity(int quantity) {
        displayNewLine();
        displayMessage(quantity + "개를 구매했습니다.");
    }

    public void displayPurchasedLottos(Lottos lottos) {
        lottos.forEach(lotto -> {
            displayMessage(lotto.getSortedLottoString());
        });
    }

    public void requestWinningNumber() {
        displayNewLine();
        displayMessage("당첨 번호를 입력해 주세요.");
    }

    public void requestBonusNumber() {
        displayNewLine();
        displayMessage("보너스 번호를 입력해 주세요.");
    }

    public void dispalyWinningStatistics(WinningResult winningResult, Profit profit) {
        displayNewLine();
        displayMessage("당첨 통계");
        displayMessage("---");
        displayMessage(winningResult.winningResultString());
        displayMessage(profit.getProfitString());
    }
}
