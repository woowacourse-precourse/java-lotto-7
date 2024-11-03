package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount(){
        String purchaseAmount = promptInput(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return purchaseAmount;
    }

    public String readWinningNumber(){
        System.out.println();
        String winningNumber = promptInput(INPUT_WINNING_NUMBER_MESSAGE);
        return winningNumber;
    }

    public String readBonusNumber(){
        String bonusNumber = promptInput(INPUT_BONUS_NUMBER_MESSAGE);
        return bonusNumber;
    }

    private String promptInput(String message){
        System.out.println(message);
        String input = readLine();
        System.out.println();
        return input;
    }


}
