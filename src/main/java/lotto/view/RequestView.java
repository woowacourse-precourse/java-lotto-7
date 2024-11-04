package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.RequestMessage.*;

public class RequestView {
    public static String getMoney(){
        System.out.println(REQUEST_MONEY.getMessage());
        return Console.readLine();
    }

    public static String getInputNumbers(){
        System.out.println(REQUEST_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String getBonusInput(){
        System.out.println(REQUEST_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
