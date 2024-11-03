package lotto.shop.bandingmachine;

import lotto.MessageCenter;

public class BandingMachine {

    TrialHistory trialHistory = new TrialHistory();
    Pos pos = new Pos();

    public void inputMoney() {
        MessageCenter.START.print();
        Integer won = pos.getMoney();
        trialHistory.saveWon(won);
        Integer totalCount = pos.getCount(won);
        trialHistory.saveTotalCount(totalCount);

    }


}
