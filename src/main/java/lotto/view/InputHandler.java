package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String getBuyMoney() {
        String input = Console.readLine();
        InputValidate.validateBuyMoney(input);
        return input;
    }
    public String[] getWinningNum(){
        String input = Console.readLine();
        InputValidate.validateWinningNumInput(input);
        return input.split(",");
    }
    public String getBonusNum(){
        String input = Console.readLine();
        InputValidate.validateBonusNum(input);
        return input;
    }
}
