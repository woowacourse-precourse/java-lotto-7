package lotto.validator;


public class MoneyValidator implements InputValidator<Integer> {
    @Override
    public Integer validate(String input) {
        int money = isNumber(input);
        checkMoney(money);
        return money;
    }


    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 유효한 숫자를 입력해야 합니다.");
        }
    }

    // 금액 검증
    private void checkMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 음수가 될 수 없습니다.");
        }
        if (money == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력 금액이 0원입니다.");
        }
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 금액은 1,000원 단위여야 합니다.");
        }
    }
}


