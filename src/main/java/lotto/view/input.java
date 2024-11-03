package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constants.Request_Messages;

public class input {
    public static void printWhiteSpace(){
        System.out.println();
    }

    public static void printInputTotalAmount(){
        System.out.println(Request_Messages.INPUT_TOTAL_AMOUNT);
    }

    public static void printInputWinningNumbers(){
        System.out.println(Request_Messages.INPUT_WINNING_NUMBER);
    }

    public static void printInputBonusNumber(){
        System.out.println(Request_Messages.INPUT_BONUS_WINNING_NUMBER);
    }

    public static int readTotalAmount() {
        printInputTotalAmount();
        return Integer.parseInt(Console.readLine());
    }

    public static List<String> readWinningNumbers(){
        printWhiteSpace();
        printInputWinningNumbers();
        return List.of(Console.readLine().replace(" ", "").split(","));
    }

    public static String readBonusNumber(){
        printWhiteSpace();
        printInputBonusNumber();
        return Console.readLine();
    }
}
