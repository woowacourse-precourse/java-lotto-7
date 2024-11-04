package lotto.model;

public class LottoMachine {
    private static final String MONEY_ERROR_MESSAGE = "[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.";
    private Integer money;

    public LottoMachine(Integer money) {
        validate(money);
        this.money = money;
    }

    private void validate(Integer money) {
        if (money % 1000 != 0)
            throw new IllegalArgumentException(MONEY_ERROR_MESSAGE);
    }
}
