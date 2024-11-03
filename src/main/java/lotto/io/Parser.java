package lotto.io;

public class Parser {

    public static int parseInputToMoney(String moneyInput) {
        int money;

        try {
            money = Integer.parseInt(moneyInput);
        } catch (Exception e) {
            throw new IllegalArgumentException("구매 금액은 정수여야 합니다.");
        }

        return money;
    }
}
