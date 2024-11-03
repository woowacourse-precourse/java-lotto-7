package view;

import camp.nextstep.edu.missionutils.Console;
import message.ErrorMessage;
import message.Message;


public class Input {

    public String inputPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE_AMOUNT.getMessage());

        String purchaseAmount = Console.readLine();
        if(purchaseAmount.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.IS_EMPTY.getErrorMessage());
        }
        System.out.println();

        return purchaseAmount;
    }
}
