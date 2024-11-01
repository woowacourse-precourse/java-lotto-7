package lotto.view;

import camp.nextstep.edu.missionutils.Console;


public class Input {
    final static String PURCHASE_AMOUNT_PROMPT = "로또 구매 금액을 입력해주세요";
    final static String WINNING_NUMBERS_PROMPT = "담청 번호를 입력해주세요";
    final static String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해주세요";

    static String request(String message) {
        System.out.println(message);
        return Console.readLine();

    }

}
