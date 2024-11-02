package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static int amountToPurchase;

    public static void main(String[] args) {

    }

    public static void readUserInput(){
        readAmountToPurchase();
    }

    public static void readAmountToPurchase(){
        String input = Console.readLine();
        amountToPurchase = Integer.parseInt(input);
    }

}
