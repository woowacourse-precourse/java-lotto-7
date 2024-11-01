package lotto.view;

import static lotto.controller.lottoController.checkTotalAmountIfValid;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.Request_Messages;
import lotto.model.Lotto;

public class input {
    public static void printWhiteSpace(){
        System.out.println();
    }

    public static void printInputTotalAmount(){
        System.out.println(Request_Messages.INPUT_TOTAL_AMOUNT);
    }

    public static void printOutputTotalCount(int count){
        System.out.println(count +Request_Messages.OUTPUT_TOTAL_COUNT);
    }

    public static void printInputWinningNumbers(){
        System.out.println(Request_Messages.INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber(){
        System.out.println(Request_Messages.INPUT_BONUS_WINNING_NUMBER);
    }

    public static int readTotalAmount() {
        printInputTotalAmount();
        int totalAmount = Integer.parseInt(Console.readLine());
        printWhiteSpace();
        return checkTotalAmountIfValid(totalAmount);
    }


    public static List<String> readWinningNumbers(){
        printInputWinningNumbers();
        List<String> number = List.of(Console.readLine().split(","));
        printWhiteSpace();
        return number;
    }

    public static int readBonusNumber(){
        printInputBonusNumber();
        int bonusNumber = Integer.parseInt(Console.readLine());
        printWhiteSpace();
        return Lotto.numberValid(bonusNumber);
    }

}
