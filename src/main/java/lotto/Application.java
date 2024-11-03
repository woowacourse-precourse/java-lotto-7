package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
  public static void main(String[] args) {
    List<Lotto> purchasedLottoList = new ArrayList<>();
    List<Integer> winnerNumber = new ArrayList<>();
    LottoQuickPick lottoQuickPick = new LottoQuickPick();
    WinnerInputHandler winnerInputHandler = new WinnerInputHandler();
    LottoResultChecker lottoResultChecker = new LottoResultChecker();

    purchasedLottoList = lottoQuickPick.quickPick();
    winnerNumber = winnerInputHandler.getWinnerNumberAll();
    lottoResultChecker.run(purchasedLottoList, winnerNumber);
  }
}