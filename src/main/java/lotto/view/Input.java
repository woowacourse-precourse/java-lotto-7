package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    static String READ_PURCHASE_AMOUNT = request();
    static String READ_WINNING_NUMBERS = request();
    static String READ_BONUS_NUMBERS = request();

    static String request() {
        return Console.readLine();

    }

}
