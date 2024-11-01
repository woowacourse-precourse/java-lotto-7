package lotto;

import lotto.View.OutputView;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        int purchasePrice = controller.gainPurchaseAmount();
        int lottoCount = controller.getLottoCount();
        List<Lotto> myLottos = Lotto.sortLottoList(lottoCount);
        Lotto answer = controller.getWinningInput();
        int bonus = controller.gainBonusInput(answer);
        List<MyResult> myResults = WinningDetails.saveMyGrades(myLottos, answer, bonus);
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.sumUpGrades(myResults);
        OutputView.printResults(winningDetails);
        int revenue = MyResult.getMyRevenue(winningDetails);
        OutputView.printReturn(purchasePrice, revenue);
    }
}
