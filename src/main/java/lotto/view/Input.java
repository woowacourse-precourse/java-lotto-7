package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    public final static String PURCHASE_AMOUNT_PROMPT = "구입 금액을 입력해주세요.";
    public final static String WINNING_NUMBERS_PROMPT = "\n담청 번호를 입력해주세요.";
    public final static String BONUS_NUMBER_PROMPT = "\n보너스 번호를 입력해주세요.";

    public static String request(String message) {
        System.out.println(message);
        return Console.readLine().trim();
    }

}
