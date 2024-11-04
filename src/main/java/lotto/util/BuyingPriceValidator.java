package lotto.util;

public class BuyingPriceValidator extends Validator<String>{

    private final static String ERROR = "[ERROR] ";
    private final static int LOTTO_PRICE_UNIT = 1000;

    @Override
    public void validate(String buyingPriceInput) {
        validIsNumber(buyingPriceInput);
        validLottoPriceUnit(buyingPriceInput);
    }

    public static void validIsNumber(String buyingPriceInput) {
        for (int i = 0; i < buyingPriceInput.length(); i++) {
            if (!Character.isDigit(buyingPriceInput.charAt(i))) {
                throw new IllegalArgumentException(ERROR + "입력은 숫자만 가능합니다.");
            }
        }
    }

    public void validLottoPriceUnit(String buyingPriceInput) {
        int buyingPrice = Integer.parseInt(buyingPriceInput);
        if (buyingPrice % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR + "구매는 1,000원 단위로 가능합니다.");
        }
    }
}
