package lotto.view;

import lotto.message.OutputMessage;

public class OutputView {
    public static void printErrorMessage(String errorMessage){
        System.out.println(errorMessage);
    }
    public static void printLottoAmountInput(){
        System.out.println(OutputMessage.REQUEST_INPUT_AMOUNT);
    }
}
