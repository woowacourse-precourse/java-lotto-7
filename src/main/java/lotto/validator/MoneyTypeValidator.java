package lotto.validator;

public class MoneyTypeValidator {

    public int validateMoneyType(String inputMoney) {
        try {
            int money = Integer.parseInt(inputMoney);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.\n");
        }
    }
}
