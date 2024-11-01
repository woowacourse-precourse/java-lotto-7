package lotto;

import lotto.View.Controller;
import lotto.View.OutputView;

import java.util.*;

import static java.lang.Math.round;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Integer purchasePrice = controller.gainPurchaseAmount();
        Integer lottoCount = controller.getLottoCount();
        List<Lotto> myLottos = Lotto.sortLottoList(lottoCount);
        Lotto answer = controller.getWinningInput();
        Integer bonus = controller.gainBonusInput(answer);
        List<MyResult> myResults = WinningDetails.saveMyGrades(myLottos, answer, bonus);
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.sumUpGrades(myResults);
        OutputView.printResults(winningDetails);
        Integer revenue = MyResult.getMyRevenue(winningDetails);
        OutputView.printReturn(purchasePrice, revenue);
    }


}
