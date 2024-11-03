package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getBuyMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        InputValidate.validateBuyMoney(input);
        return input;
    }
    public String[] getWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        InputValidate.validateWinningNumInput(input);
        return input.split(",");
    }
    public String getBonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        InputValidate.validateBonusNum(input);
        return input;
    }
}
