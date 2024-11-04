package lotto.model;

public class Wallet {
    private static final String CHANGE_EXSIT_EXCEPTION_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 가능 금액은 1000원 이상, 1000000원 이하입니다.";

    private final Integer money;

    public Wallet(Integer purchaseMoney) {
        validate(purchaseMoney);
        this.money = purchaseMoney;
    }

    private void validate(Integer purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(CHANGE_EXSIT_EXCEPTION_MESSAGE);
        }
        if (purchaseMoney < 1000 || purchaseMoney > 1_000_000) {
            throw new IllegalArgumentException(OUT_OF_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public Integer getAffordableLottoAmount() {
        return money / 1000;
    }

    public Integer getMoney() {
        return money;
    }
}
