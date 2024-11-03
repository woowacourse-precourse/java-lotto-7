package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String price() {
        System.out.println(ASK_AMOUNT);
        return Console.readLine();
    }

    public String winningNumber() {
        System.out.println(ASK_WINNING_NUMBER);
        return Console.readLine();
    }

    public String bonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return Console.readLine();
    }
}






    
