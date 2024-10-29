package lotto.domain;

public record Price(
        int value
) {

    public static Price validatePrice(String originPrice) {
        int price = validatePriceInteger(originPrice);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 가격은 1000으로 나뉘어 떨어져야 합니다.");
        }
        return new Price(price);
    }

    private static int validatePriceInteger(String originPrice) {
        try {
            return Integer.parseInt(originPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 가격은 숫자가 입력되어야 합니다.");
        }
    }
}
