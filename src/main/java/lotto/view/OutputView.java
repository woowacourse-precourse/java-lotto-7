package lotto.view;

import lotto.model.Lotto;
import lotto.model.WinningCountDTO;

import java.util.List;

public class OutputView {
    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printWinningResult(WinningCountDTO winningCountDTO) {
        printMessage("당첨 통계");
        printMessage("---");
        List<Integer> winningCount = winningCountDTO.getWinningCount();
        printMessage("3개 일치 (5,000원) - " + winningCount.get(0) + "개");
        printMessage("4개 일치 (50,000원) - " + winningCount.get(1) + "개");
        printMessage("5개 일치 (1,500,000원) - " + winningCount.get(2) + "개");
        printMessage("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCount.get(3) + "개");
        printMessage("6개 일치 (2,000,000,000원) - " + winningCount.get(4) + "개");
    }
}
