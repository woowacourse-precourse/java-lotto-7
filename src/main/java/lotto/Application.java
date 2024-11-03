package lotto;

import lotto.shop.bandingmachine.BandingMachine;
import lotto.shop.bandingmachine.TrialHistory;

public class Application {
    public static void main(String[] args) {

        BandingMachine bandingMachine = new BandingMachine();

        bandingMachine.inputMoney();
        TrialHistory trialHistory = bandingMachine.getTrialHistory();
        bandingMachine.drawNumbers(trialHistory.getTotalCount());


    }
}
