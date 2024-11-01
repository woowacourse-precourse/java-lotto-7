package lotto;

public class LottoUtility {
    public static void validatePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if(amount % 1000 > 0) {
                throw new IllegalArgumentException("[ERROR] 구입금액은 1,000 단위로 입력하셔야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 숫자만 입력하셔야 합니다.");
        }
    }
}
