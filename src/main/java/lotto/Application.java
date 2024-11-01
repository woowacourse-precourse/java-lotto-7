package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    private static final String ASK_PURCHASE_MONEY_MESSAGE_STRING = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS_MESSAGE_STRING = "당첨 번호를 입력해 주세요.";

    public static void main(String[] args) {
        
    }

    private String readPurchaseMoney() {
        System.out.println(ASK_PURCHASE_MONEY_MESSAGE_STRING);
        return Console.readLine();        
    }

    private String readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS_MESSAGE_STRING);
        return Console.readLine();
    }
}
