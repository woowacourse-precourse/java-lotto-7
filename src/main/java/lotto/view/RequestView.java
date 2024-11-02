package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.RequestMessage.REQUEST_MONEY;

public class RequestView {
    public static String getMoney(){
        System.out.println(REQUEST_MONEY.getMessage());
        return Console.readLine();
    }
}
