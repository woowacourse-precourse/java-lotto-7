package lotto;

import lotto.committee.HeadQuarter;
import lotto.committee.WonNumbers;
import lotto.shop.bandingmachine.TouchScreen;
import lotto.user.PrizeHistory;
import lotto.user.Result;
import lotto.user.UserAnalysis;

public class Application {
    public static void main(String[] args) {

        TouchScreen touchScreen = new TouchScreen();
        HeadQuarter headQuarter = new HeadQuarter();
        UserAnalysis userAnalysis = new UserAnalysis();
        Result result = new Result();

        touchScreen.inputMoney();
        touchScreen.pushDraw();

        WonNumbers wonNumbers = headQuarter.pickNumbers();
        PrizeHistory prizeHistory = result.getResult(wonNumbers);

        userAnalysis.getAnalysis(prizeHistory);
    }
}
