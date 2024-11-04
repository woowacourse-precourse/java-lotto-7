package lotto.view;

import lotto.utility.Utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {
    private enum InputMessage{
        INPUT_PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER_PROMPT("\n당첨 번호를 입력해 주세요."),
        INPUT_BOUNS_NUMBER_PROMPT("\n보너스 번호를 입력해 주세요.");

        final private String message;

        public String getMessage(){
            return message;
        }

        InputMessage(String message) {
            this.message = message;
        }
    }

    public String promptPurchaseAmountInput(){
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT_PROMPT.getMessage());
        String inputMessage = readLine();
        Utils.checkEmptyInput(inputMessage);
        return inputMessage;
    }
    public String promptWinningNumberInput(){
        System.out.println(InputMessage.INPUT_WINNING_NUMBER_PROMPT.getMessage());
        String inputMessage = readLine();
        Utils.checkEmptyInput(inputMessage);
        return inputMessage;
    }
    public String promptBonusNumberInput(){
        System.out.println(InputMessage.INPUT_BOUNS_NUMBER_PROMPT.getMessage());
        String inputMessage = readLine();
        Utils.checkEmptyInput(inputMessage);
        return inputMessage;
    }
}
