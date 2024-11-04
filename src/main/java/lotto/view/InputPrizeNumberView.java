package lotto.view;

import static lotto.constants.OutputMessageConstants.GET_BONUS_NUMBER_MESSAGE;
import static lotto.constants.OutputMessageConstants.GET_SIX_PRIZE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputPrizeNumberView {

    public String getSixPrizeNumber() {
        System.out.println(GET_SIX_PRIZE_MESSAGE);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
