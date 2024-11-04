package lotto.domain;

import lotto.util.BuyingPriceParser;

public class BuyingPrice {
    private final int price;
    private final static String ERROR = "[ERROR] ";
    private final static int LOTTO_PRICE_UNIT = 1000;

    public BuyingPrice(String buyingPriceInput) {
        validIsNumber(buyingPriceInput);
        validLottoPriceUnit(buyingPriceInput);
        this.price = BuyingPriceParser.toIntStringPriceParser(buyingPriceInput);
    }

    public int getPrice() {
        return price;
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
