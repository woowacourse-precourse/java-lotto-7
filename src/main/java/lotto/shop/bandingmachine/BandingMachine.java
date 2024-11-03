package lotto.shop.bandingmachine;

import lotto.MessageCenter;

public class BandingMachine {

    TrialHistory trialHistory = new TrialHistory();
    Pos pos = new Pos();

    public void inputMoney() {
        MessageCenter.START.print();
        getMoney();
        getCount();
        System.out.println(trialHistory.getTotalCount() + MessageCenter.COUNT.get());
    }

    public void drawNumbers() {

    }

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
