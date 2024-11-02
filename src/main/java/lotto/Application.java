package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static int amountToPurchase;

    public static void main(String[] args) {
        readUserInput();
    }

    public static void readUserInput(){
        readAmountToPurchase();
    }

    public static void readAmountToPurchase(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        amountToPurchase = (Integer.parseInt(input) / 1000) * 1000;
    }

}
