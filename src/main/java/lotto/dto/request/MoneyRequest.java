package lotto.dto.request;

public record MoneyRequest(
        int money
) {
    public static MoneyRequest of(int money) {
        return new MoneyRequest(money);
    }
}
