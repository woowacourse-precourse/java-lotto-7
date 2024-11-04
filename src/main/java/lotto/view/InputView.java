package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final String CASH_INPUT = "구입금액을 입력해 주세요.";
    private final String WINNING_NUM_INPUT = "당첨 번호를 입력해 주세요.";
    private final String BONUS_NUM_INPUT = "보너스 번호를 입력해 주세요.";

    public String getCashInput(){
        System.out.println(CASH_INPUT);
        return readLine();
    }

    public String getWinningNumInput(){
        System.out.println(WINNING_NUM_INPUT);
        return readLine();
    }

    public String getBonusNumInput(){
        System.out.println(BONUS_NUM_INPUT);
        return readLine();
    }
}
