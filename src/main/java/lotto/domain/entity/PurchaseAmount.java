package lotto.domain.entity;

public record PurchaseAmount(int amount) {

    public static PurchaseAmount from(String input) {
        return new PurchaseAmount(Integer.parseInt(input));
    }
}
