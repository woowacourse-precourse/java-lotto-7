package lotto.util.parser;

public class BuyingPriceParser {
    public static int toIntStringPriceParser(String buyingPriceInput) throws IllegalArgumentException  {
        try {
            return Integer.parseInt(buyingPriceInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 숫자만 입력 가능합니다.");
        }
    }
}
