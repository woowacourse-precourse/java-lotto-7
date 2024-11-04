package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMoneyToBuy {
    public int inputMoneyToBuy() {
        System.out.println("구입금액을 입력해주세요");
        String MoneyString = Console.readLine();

        int MoneyAmount = Integer.parseInt(MoneyString);

        try {
            MoneyAmount = Integer.parseInt(MoneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }
        if (MoneyAmount <= 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입금액은 1,000원입니다");
        }

        public int getMoneyAmount() {
            return MoneyAmount;
        }
    }
}