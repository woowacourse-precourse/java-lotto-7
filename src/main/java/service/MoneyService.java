package service;

import camp.nextstep.edu.missionutils.Console;

public class MoneyService {

    public int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
