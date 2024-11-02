package lotto;

public class VaildationUtil {
    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;
    private final int LOTTO_PRICE = 1000;

    public void validateAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수로 입력해야 합니다.");
        }
    }

    public int parseAndValidateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력하세요.");
        }
    }
}
