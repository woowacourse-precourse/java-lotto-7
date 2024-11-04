package lotto.validator;

public class UserBuyingValidator {
    private final static int LOTTO_PRICE = 1000;

    public void validateBuyingValidation(String buyingPrice) {
        validIsZero(buyingPrice);
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    private static void validIsZero(String buyingPrice) {
        if (buyingPrice.equals("0")) {
            throw new IllegalArgumentException("0원으로 로또를 구매할 수 없습니다.");
        }
    }

    public void validPrice(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("구매는 1,000원 단위로 가능합니다.");
        }
    }

    public static void validIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new NumberFormatException("입력은 숫자만 가능합니다.");
            }
        }
    }
}
