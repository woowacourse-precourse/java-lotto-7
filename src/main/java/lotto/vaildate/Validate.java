package lotto.vaildate;

public class Validate {

    public static int purchasePriceValidate(String price) {
        int purchasePrice = parseIntegerValidate(price);

        if (purchasePrice % 1000 != 0 || purchasePrice < 0) {
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
        }

        return purchasePrice / 1000;
    }

    public static int parseIntegerValidate(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로만 입력해주세여");
        }
    }

}
