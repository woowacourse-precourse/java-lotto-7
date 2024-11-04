package valid;

public class ValidationForOne {
    public Integer consistOfOnlyPositiveNumbers(String userIntputMoney) {
        Integer money = 0;
        try {
            money = Integer.parseInt(userIntputMoney);
        } catch (NumberFormatException ie) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (money <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 보다 큰 숫자를 입력 해주세요.");
        }

        return money;
    }

    public boolean devisibleByThousands(Integer money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로만 구매 가능합니다.");
        }

        return true;
    }
}
