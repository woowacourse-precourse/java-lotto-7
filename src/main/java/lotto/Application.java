package lotto;

import lotto.committee.HeadQuarter;
import lotto.committee.WonNumbers;
import lotto.shop.bandingmachine.TouchScreen;
import lotto.shop.bandingmachine.TrialHistory;
import lotto.user.Result;
import lotto.user.UserStorage;

public class Application {
    public static void main(String[] args) {

        TouchScreen touchScreen = new TouchScreen();
        HeadQuarter headQuarter = new HeadQuarter();
        UserStorage userStorage = new UserStorage();
        Result result = new Result();

        touchScreen.inputMoney();
        touchScreen.pushDraw();

        WonNumbers wonNumbers = headQuarter.pickNumbers();
        result.getResult(wonNumbers);







    }
}
