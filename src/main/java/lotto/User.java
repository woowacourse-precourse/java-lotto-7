package lotto;

import java.util.NoSuchElementException;

public class User {
    private static final int STANDARD_UNIT = 1_000;
    private static final String ERROR_PREFIX = "[ERROR] ";

    private int money;

    public User(String inputMoney) {
        validateInput(inputMoney);
        int money = Integer.parseInt(inputMoney);
        validateMoney(money);
        this.money = money;
    }

    private void validateInput(String inputMoney) {
        if (inputMoney == null || inputMoney.isBlank()) {
            throw new IllegalArgumentException(ERROR_PREFIX + "금액을 입력해주세요.");
        }
        if (!inputMoney.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자만 입력 가능합니다.");
        }
    }

    private void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "금액은 0보다 커야합니다.");
        }
        if (money % STANDARD_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX + "금액은 1,000 단위로 나눠 떨어져야 합니다.");
        }
    }

    public int getMoney() {
        return money;
    }
}
