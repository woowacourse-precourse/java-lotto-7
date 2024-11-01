package lotto;

import lotto.View.OutputView;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        MyInfo myInfo = new MyInfo();
        WinningDetails winningDetails = new WinningDetails();
        myInfo.gainPurchaseAmount();
        myInfo.setLottoCount(myInfo.getLottoCount());
        myInfo.setMyLottos(Lotto.sortLottoList(myInfo.getLottoCount()));
        myInfo.setAnswerLotto(myInfo.gainWinningInput());
        myInfo.setBonusNumber(myInfo.gainBonusInput(myInfo.getAnswerLotto()));
        List<MyResults> myResults = WinningDetails
                .saveMyGrades(myInfo.getMyLottos(), myInfo.getAnswerLotto(), myInfo.getBonusNumber());
        winningDetails.sumUpGrades(myResults);
        OutputView.printResults(winningDetails);
        myInfo.setRevenue(myInfo.gainMyRevenue(winningDetails));
        myInfo.setMyReturn(myInfo.gainReturn(myInfo.getPurchasePrice(), myInfo.getRevenue()));
        OutputView.printReturn(myInfo.getMyReturn());
    }
}
