package lotto;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleHandler {

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        return invertNumber(money);
    }


    private int invertNumber(String number) {
        try{
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
