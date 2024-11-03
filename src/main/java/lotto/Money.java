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

    public static int validate(String inputNumber) {
        try {
            int money = Integer.parseInt(inputNumber);
            if (money % LottoInformation.LOTTO_PRICE_UNIT.getValue() != 0) {
                throw new IllegalArgumentException(ErrorMessage.DIVISIBLE_BY_THOUSAND.getMessage());
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
