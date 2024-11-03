package lotto.util;

public class InputValidator {
    private final static int TICKET_PRICE = 1000;

    public int validatePrice(String str) {
        checkBlank(str);
        int price = convertStrToInt(str);

        checkCanDivide(price);
        return price;
    }

    private void checkCanDivide(int price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void checkBlank(String str) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열을 입력하면 안됩니다.");
        }
    }

    public int convertStrToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
