package lotto.util.parser;

public class BuyingPriceParser {
    private static final String INVALID_FORMAT_ERROR = "구입금액은 숫자만 입력 가능합니다.";

    public static int toIntStringPriceParser(String buyingPriceInput) throws IllegalArgumentException  {
        try {
            return Integer.parseInt(buyingPriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_FORMAT_ERROR);
        }
    }
}
