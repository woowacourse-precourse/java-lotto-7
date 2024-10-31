package lotto.validate;

public class MoneyValidate {

    public int validateMoney(String inputMoney) {
        int money = validateIsInt(inputMoney);
        validateIsMultipleOfThousand(money);
        return money;
    }

    private int validateIsInt(String inputMoney) {
        try {
            int money = Integer.parseInt(inputMoney);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.\n");
        }
    }

    private void validateIsMultipleOfThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해주세요.\n");
        }
    }
}
