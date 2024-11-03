package lotto;

import lotto.shop.bandingmachine.TouchScreen;
import lotto.shop.bandingmachine.TrialHistory;

public class Application {
    public static void main(String[] args) {

        TouchScreen touchScreen = new TouchScreen();

        touchScreen.inputMoney();
        TrialHistory trialHistory = touchScreen.getTrialHistory();
        touchScreen.pushDraw(trialHistory.getTotalCount());


    }
}
