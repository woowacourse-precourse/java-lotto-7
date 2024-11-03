package lotto.shop.bandingmachine;

import lotto.MessageCenter;

public class BandingMachine {

    TrialHistory trialHistory = new TrialHistory();
    Pos pos = new Pos();

    public void inputMoney() {
        MessageCenter.START.print();
        Integer money = pos.getMoney();
        trialHistory.savePayment(money);
        Integer totalCount = pos.getCount(money);
        trialHistory.saveTotalCount(totalCount);

    }


}
