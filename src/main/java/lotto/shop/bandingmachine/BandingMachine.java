package lotto.shop.bandingmachine;

import java.util.List;
import lotto.MessageCenter;
import lotto.shop.Pos;

public class BandingMachine {

    TrialHistory trialHistory = new TrialHistory();
    DrawnNumbers drawnNumbers = DrawnNumbers.create();
    DrawSystem drawSystem = new DrawSystem(drawnNumbers);
    Pos pos = new Pos();

    public void inputMoney() {
        MessageCenter.START.print();
        getMoney();
        getCount();
        System.out.println(trialHistory.getTotalCount() + MessageCenter.COUNT.get());
    }

    public void drawNumbers(Integer totalCount) {
        getDrawnNumberPacks(totalCount);
        saveUser
        System.out.println();
    }



    private void getDrawnNumberPacks(Integer totalCount){
        List<DrawnNumbers> drawnNumberPacks = drawSystem.runDraws(totalCount);
        trialHistory.saveDrawnNumberPacks(drawnNumberPacks);
    };

    private void getMoney() {
        Integer money = pos.checkMoney();
        trialHistory.savePayment(money);
    }

    private void getCount() {
        Integer payment = trialHistory.getPayment();
        Integer totalCount = pos.checkCount(payment);
        trialHistory.saveTotalCount(totalCount);
    }
}
