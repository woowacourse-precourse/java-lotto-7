package valid;

public class ValidationForOne {
    public boolean consistOfOnlyPositiveNumbers(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException ie) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }

        if (Integer.parseInt(money) <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 보다 큰 숫자를 입력 해주세요.");
        }

        return true;
    }

    public boolean devisibleByThousands(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로만 구매 가능합니다.");
        }

        return true;
    }
}
