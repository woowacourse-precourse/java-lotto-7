package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    static final String INPUT_ORDER_PRICE = "구입금액을 입력해 주세요.";
    static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputOrderPrice() {
        System.out.println(INPUT_ORDER_PRICE);
        return Console.readLine();
    }

    public static String inputWinningNumber(){
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBounsNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}