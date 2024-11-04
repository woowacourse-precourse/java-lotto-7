package lotto.dto;

public class PurchaseMoneyRequestDTO {
    private static final String NON_NUMBER_MESSAGE = "[ERROR] 구입금액은 숫자만 입력해주세요.";

    private int money;

    public PurchaseMoneyRequestDTO(String moneyInput) {
        this.money = parseMoney(moneyInput);
    }

    public int getMoney() {
        return money;
    }

    private int parseMoney(String moneyInput) {
        try {
            return Integer.parseInt(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_MESSAGE);
        }
    }
}
