package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Constants.RequestMessages;

public class input {
    public static String readTotalAmount() {
        printInputTotalAmount();
        return Console.readLine();
    }

    public static void printInputTotalAmount(){
        System.out.println(RequestMessages.INPUT_TOTAL_AMOUNT.getMessage());
    }

    public static List<String> readWinningNumbers(){
        printWhiteSpace();
        printInputWinningNumbers();
        return List.of(Console.readLine().replace(" ", "").split(","));
    }

    public static void printWhiteSpace(){
        System.out.println();
    }

    public static void printInputWinningNumbers(){
        System.out.println(RequestMessages.INPUT_WINNING_NUMBER.getMessage());
    }

    public static String readBonusNumber(){
        printWhiteSpace();
        printInputBonusNumber();
        return Console.readLine();
    }

    public static void printInputBonusNumber(){
        System.out.println(RequestMessages.INPUT_BONUS_WINNING_NUMBER.getMessage());
    }
}
