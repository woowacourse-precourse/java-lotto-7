package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Money {

    public static int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String inputMoney = Console.readLine();
            return validate(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private static int validate(String inputNumber) {
        try {
            int money = Integer.parseInt(inputNumber);
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1,000원으로 나누어 떨어지게 입력하세요");
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요");
        }
    }
}
