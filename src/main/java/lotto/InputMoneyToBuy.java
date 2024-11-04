package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputMoneyToBuy {
    private int moneyAmount;

    public int inputMoneyToBuy() {
        System.out.println("구입금액을 입력해주세요");
        try {
            String moneyString = Console.readLine();
            moneyAmount = Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
        }
        if (moneyAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입금액은 1,000원입니다");
        }
        return moneyAmount;
    }
    public int getMoneyAmount() {
            return moneyAmount;
    }
}
