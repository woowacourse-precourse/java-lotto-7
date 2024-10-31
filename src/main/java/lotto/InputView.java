package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String WINNING_NUMBER_REGEX_PATTERN = "(\\d{1,2},)\\d{1,2}";
    private static final String BONUS_NUMBER_REGEX_PATTERN = "\\d+";

    public String inputMoney() {
        InputMoneyValidator inputMoneyValidator = new InputMoneyValidator();
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String money = Console.readLine();
                inputMoneyValidator.validate(money);
                return money;
            }catch (IllegalArgumentException e){
                System.out.println("no");
            }
        }


    }

    public String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
