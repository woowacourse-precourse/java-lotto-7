package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputPrizeNumberView {

    private static final String GET_SIX_PRIZE_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String GET_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getSixPrizeNumber() {
        System.out.println(GET_SIX_PRIZE_MESSAGE);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
