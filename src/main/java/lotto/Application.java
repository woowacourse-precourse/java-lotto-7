package lotto;

import lotto.View.OutputView;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        MyInfo myInfo = new MyInfo();
        myInfo.gainPurchaseAmount();
        int lottoCount = myInfo.getLottoCount();
        List<Lotto> myLottos = Lotto.sortLottoList(lottoCount);
        Lotto answer = myInfo.getWinningInput();
        int bonus = myInfo.gainBonusInput(answer);
        List<MyResults> myResults = WinningDetails.saveMyGrades(myLottos, answer, bonus);
        WinningDetails winningDetails = new WinningDetails();
        winningDetails.sumUpGrades(myResults);
        OutputView.printResults(winningDetails);
        int revenue = MyResults.getMyRevenue(winningDetails);
        OutputView.printReturn(myInfo.getPurchasePrice(), revenue);
    }
}
