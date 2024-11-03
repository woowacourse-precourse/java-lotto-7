package lotto.domain;

public class Price {

    private final Long price;

    public Price(Long price) {
        validateDivisibleByThousand(price);
        validateNotNegative(price);
        this.price = price;
    }

    private static void validateNotNegative(Long price) {
        if (price < 0) {
            throw new IllegalArgumentException("음이 아닌 정수여야 합니다");
        }
    }

    private static void validateDivisibleByThousand(Long price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1,000원 단위로 입력해야 합니다");
        }
    }
}
