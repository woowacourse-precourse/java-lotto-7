package lotto.view;

import static lotto.controller.lottoController.checkTotalAmountIfValid;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Request_Messages;

public class input {
    public static void printInputTotalAmount(){
        System.out.println(Request_Messages.INPUT_TOTAL_AMOUNT);
    }

    public static void printOutputTotalCount(int count){
        System.out.println(count +Request_Messages.OUTPUT_TOTAL_COUNT);
    }

    public static int readTotalAmount() {
        printInputTotalAmount();
        int totalAmount = Integer.parseInt(Console.readLine());
        return checkTotalAmountIfValid(totalAmount);
    }

}
