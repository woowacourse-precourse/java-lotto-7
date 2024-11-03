package lotto.model;

public class Wallet {
    private static final String NOT_INTEGER_EXCEPTION_MESSAGE = "[ERROR] 정수 이외 값을 입력할 수 없습니다.";
    private static final String CHANGE_EXSIT_EXCEPTION_MESSAGE = "[ERROR] 1000원 단위로 입력해주세요.";
    private static final String OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 가능 금액은 1000원 이상, 1000000원 이하입니다.";

    private final Integer money;

    public Wallet(String purchaseMoney) {
        validate(purchaseMoney);
        this.money = Integer.parseInt(purchaseMoney);
    }

    private void validate(String purchaseMoney) {
        int money;
        try {
            money = Integer.parseInt(purchaseMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION_MESSAGE);
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(CHANGE_EXSIT_EXCEPTION_MESSAGE);
        }
        if (money < 1000 || money > 1_000_000) {
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
